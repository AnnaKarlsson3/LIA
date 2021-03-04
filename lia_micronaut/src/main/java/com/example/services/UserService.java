package com.example.services;


import com.example.entities.User;
import com.example.repositories.UserRepo;

import javax.inject.Inject;
import java.util.List;


public class UserService {

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Inject
    UserRepo userRepo;

    public User registerUser(User user){
        //String password = encoder.encode(user.getPassword());
        //user.setPassword(password);
        User dbUser = userRepo.findByEmail(user.getEmail());
        if(dbUser != null) {
            return null;
        }
        return userRepo.save(user);
    }

    public User loginUser(User user){
        User dbUser = userRepo.findByEmail(user.getEmail());
        if(dbUser != null) {
            if (user.getPassword().equals(dbUser.getPassword())) {
                return dbUser;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }

    public User updateUser(int id, User user){
        User dbUser = userRepo.findById(id);
        if(dbUser != null){
            dbUser.setUsername(user.getUsername());
            dbUser.setEmail(user.getEmail());
            dbUser.setPassword(user.getPassword());

            return userRepo.save(dbUser);
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
