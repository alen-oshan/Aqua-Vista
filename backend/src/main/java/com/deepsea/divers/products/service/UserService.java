package com.deepsea.divers.products.service;

import com.deepsea.divers.products.entity.User;
import com.deepsea.divers.products.exceptions.UserNotFoundException;
import com.deepsea.divers.products.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Register a new user
    public User register(User user){
        return userRepository.save(user);
    }

    // Update user
    public User update(Long id, User updatedUser){
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        user.setFName(updatedUser.getFName());
        user.setLName(updatedUser.getLName());
        user.setRole(updatedUser.getRole());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

    // Login
    public Optional<User> login(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        return user.filter(u -> u.getPassword().equals(password));
    }

    // Delete user by id
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    // Get all users
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
}

