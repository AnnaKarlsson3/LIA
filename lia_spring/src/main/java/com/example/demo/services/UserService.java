package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Autowired
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
}
