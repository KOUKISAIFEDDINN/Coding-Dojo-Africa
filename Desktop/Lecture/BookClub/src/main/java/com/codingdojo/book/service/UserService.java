package com.codingdojo.book.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.book.entity.LoginUser;
import com.codingdojo.book.entity.User;
import com.codingdojo.book.reposiotry.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
    
    public User register(User newUser, BindingResult result) {
    
    	// TO-DO - Reject values or register if no errors:
    	 // Reject if email is taken (present in database)
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
        	result.rejectValue("email", "unique", "email is already taken !");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "unique", "password doesnt match !");
        }
        // Return null if result has errors
    if(result.hasErrors()) {
    	return null;
    }else {
    	// Hash and set password, save user to database
    	String hashedPw = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPw);
    	return userRepo.save(newUser);
    } 
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    // TO-DO - Reject values:
    	// Find user in the DB by email
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
	
    // Reject if NOT present
    if(!potentialUser.isPresent()) {
    	result.rejectValue("email", "unique", "email is already taken !");
    }
    // Reject if BCrypt password match fails
    	User user = potentialUser.get();
    	if(!BCrypt.checkpw(newLoginObject.getPassword(),user.getPassword())) {
    		result.rejectValue("password", "match", "password doesnt match !");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}else {
    		return user;
    	}
    // Return null if result has errors
    // Otherwise, return the user object
}
}
