package com.auth.loginandregistration.repository;

import java.util.Optional;

import com.auth.loginandregistration.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // for logging user
    Optional<User>findByEmail(String email);

}