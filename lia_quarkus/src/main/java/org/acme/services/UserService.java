package org.acme.services;


import org.acme.entities.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserService {

    public User registerUser(User user){
        User dbUser = User.findByEmail(user.email);
        if(dbUser != null){
            return null;
        }
        user.persist();
        return user;
    }

    public User loginUser(User user){
        User dbUser = User.findByEmail(user.email);
        if(dbUser != null){
            if(user.email.equals(dbUser.email)){
                return dbUser;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return User.listAll();
    }

    public User updateUser(long id, User user){
        User dbUser = User.findById(id);
        if(dbUser != null){
            dbUser.username = user.username;
            dbUser.email = user.email;
            dbUser.password = user.password;
            dbUser.persist();
            return dbUser;
        }
        return null;
    }

    public String deleteUser(long id){
        User dbUser = User.findById(id);
        if(dbUser != null) {
            User.deleteUser(id);
            return "user deleted";
        }
        return null;
    }
}
