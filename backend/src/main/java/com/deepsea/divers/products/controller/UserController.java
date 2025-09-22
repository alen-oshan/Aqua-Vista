package com.deepsea.divers.products.controller;

import com.deepsea.divers.products.entity.User;
import com.deepsea.divers.products.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public Optional<User> loginUser(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        return userService.update(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/get")
    public Iterable<User> getAllUsers(){
        return userService.getAll();
    }

}
