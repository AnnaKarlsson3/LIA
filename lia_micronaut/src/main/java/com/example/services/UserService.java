package com.example.services;


import com.example.entities.User;
import com.example.repositories.UserRepo;
import io.micronaut.core.annotation.Internal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {

    @Inject
    UserRepo userRepo;

    public User registerUser(User user){
       /* User dbUser = userRepo.findByEmail(user.getEmail());
        if(dbUser != null) {
            return null;
        }*/
        return userRepo.save(user);
    }

    public User loginUser(User user){
        User dbUser = userRepo.findById(user.getId());
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
