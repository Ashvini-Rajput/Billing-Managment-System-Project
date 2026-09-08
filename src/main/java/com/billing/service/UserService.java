package com.billing.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.entity.User;
import com.billing.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // Step 2 — Add Delete User
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
   
    //  Step 3 — Add Update User
    public User updateUser(Long id, String name, String email, String password) {

        User user = userRepository.findById(id).orElse(null);

        if(user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        }

        return null;
    }
    
 // ADD THIS LOGIN METHOD  
    
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
   
    

    
    
}
