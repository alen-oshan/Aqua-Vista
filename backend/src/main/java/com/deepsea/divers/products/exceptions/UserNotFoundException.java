package com.deepsea.divers.products.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User id with "+ id + " not found");
    }
}
