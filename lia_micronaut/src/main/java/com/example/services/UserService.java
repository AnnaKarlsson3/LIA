package com.example.services;


import com.example.entities.User;
import com.example.repositories.UserRepo;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;


public class UserService {

    @Inject
    UserRepo userRepo;

    public User registerUser(User user){
        Optional<User> dbUser = userRepo.findByEmail(user.getEmail());
        System.out.println(dbUser);
        if(!dbUser.isEmpty()) {
            return null;
        }
        return userRepo.save(user);
    }

    public Optional<User> loginUser(User user){
        Optional<User> dbUser = userRepo.findByEmail(user.getEmail());
        if(!dbUser.isEmpty()) {
            if (user.getPassword().equals(dbUser.get().getPassword())) {
                return dbUser;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }

    public User updateUser(int id, User user){
        userRepo.update(id, user.getUsername());
        User dbUser = userRepo.findById(id);
        if(dbUser != null){
         return dbUser;
        }
        return null;
    }

    public String deleteUser(int id){
        User dbUser = userRepo.findById(id);
        if(dbUser != null){
            userRepo.deleteById(id);
            return "user deleted";
        }
        return null;
    }
}
