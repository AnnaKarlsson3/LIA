package com.example.services;

import com.example.entities.User;
import com.example.repositories.UserRepo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {

    @Inject
    UserRepo userRepo;

    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }
}
