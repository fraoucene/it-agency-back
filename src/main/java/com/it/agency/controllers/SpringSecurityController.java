package com.it.agency.controllers;

import com.it.agency.beans.User;
import com.it.agency.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/user")
public class SpringSecurityController {

    private UserRepository repository;

    @Inject
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(
            params = {"user"},
            method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam(value = "user") String user) {
        return new ResponseEntity<>(repository.findUserWithName(user).get(), HttpStatus.OK);
    }

}