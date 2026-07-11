package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.entity.User;
import com.billing.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add User using browser (GET request)
    @GetMapping("/add")
    public User addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return userService.saveUser(user);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/get")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }
    
    // Step 2 — Add Delete User
    
    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    
    // Step 3 — Add Update User
    
    @GetMapping("/update")
    public User updateUser(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        return userService.updateUser(id, name, email, password);
    }
    
    @GetMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        return userService.login(email, password);
    }
    
    
}