package com.andryanstgkr.parsamosir.api.base;

import com.andryanstgkr.parsamosir.api.exception.UserNotFoundException;
import com.andryanstgkr.parsamosir.api.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseException extends Exception {
    Logger logger = LoggerFactory.getLogger(BaseException.class);

    public BaseException(String message, Object o) {
        try {
            if (o instanceof User) {
                throw new UserNotFoundException(message);

            }
        } catch (UserNotFoundException e) {

            e.printStackTrace();
        }
    }
}
