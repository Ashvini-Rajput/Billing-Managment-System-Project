package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
    User findByEmailAndPassword(String email, String password);

}