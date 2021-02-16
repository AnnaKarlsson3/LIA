package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Autowired
    UserRepo userRepo;

    public void registerUser(User user){
        //String password = encoder.encode(user.getPassword());
        //user.setPassword(password);
        userRepo.save(user);
    }
}
