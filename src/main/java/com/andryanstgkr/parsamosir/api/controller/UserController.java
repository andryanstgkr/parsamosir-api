package com.andryanstgkr.parsamosir.api.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.andryanstgkr.parsamosir.api.exception.UserNotFoundException;
import com.andryanstgkr.parsamosir.api.model.User;
import com.andryanstgkr.parsamosir.api.service.UserService;
import com.andryanstgkr.parsamosir.api.utilities.ResponseHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        try {
            if (userList==null) {
                throw new UserNotFoundException("User not found");
            }
        } catch (UserNotFoundException e) {
            logger.error("UserNotFoundException: " + e.getMessage());
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, userList);
        }
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") String id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        try {
            if (user==null) {
                throw new EntityNotFoundException("User with ID: " + id + " not found");
            }
        } catch (EntityNotFoundException e) {
            logger.error("UserNotFoundException: " + e.getMessage());
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, user);
        }
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, user);
    }

    @GetMapping("/userName/{userName}")
    public ResponseEntity<Object> getUserByUserName(@PathVariable("userName") String userName) {
        User user = userService.getUserByUserName(userName);
        try {
            if (user==null) {
                throw new EntityNotFoundException("User with userName: " + userName + " not found");
            }
        } catch (EntityNotFoundException e) {
            logger.error("EntityNotFoundException: " + e);
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, user);
        }
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, user);
    }

}
