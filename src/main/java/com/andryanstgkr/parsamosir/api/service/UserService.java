package com.andryanstgkr.parsamosir.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.andryanstgkr.parsamosir.api.exception.UserNotFoundException;
import com.andryanstgkr.parsamosir.api.model.User;
import com.andryanstgkr.parsamosir.api.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Iterator<User> iteratorUser = userRepository.findAll().iterator();
        iteratorUser.forEachRemaining(userList::add);
        return userList;
    }

    public User getUserById(String id) throws UserNotFoundException{
        Optional<User> optUser = userRepository.findUserById(id);
        User user = optUser.orElse(null);
        return user;
    }

    public User getUserByUserName(String userName) {
        Optional<User> optUser = userRepository.findUserByUserName(userName);
        User user = optUser.orElse(null);
        return user;
    }

    
}
