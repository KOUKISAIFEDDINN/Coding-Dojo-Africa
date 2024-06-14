package com.codingdojo.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.book.entity.LoginUser;
import com.codingdojo.book.entity.User;
import com.codingdojo.book.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userServ;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		model.addAttribute("user", new User());
		return "book/Registration.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		
		userServ.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "book/Registration.jsp";
		}else {
			session.setAttribute("user_id",user.getId());
			return "redirect:/all";
		}
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser login, BindingResult result,Model model,HttpSession session) {
		
		
		User user = userServ.login(login, result);
		
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "book/Registration.jsp";
		}
		session.setAttribute("user_id",user.getId());
		return "redirect:/all";
	}
	
}
