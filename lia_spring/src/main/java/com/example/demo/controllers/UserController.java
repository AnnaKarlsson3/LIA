package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        User registerdUser = userService.registerUser(user);
        if(registerdUser == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("user already exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(registerdUser);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user){
        User loggedInUser = userService.loginUser(user);
        if(loggedInUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong email or password");
        }
        return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable(value = "id") int id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        if(updatedUser == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id){
        String deletedUser = userService.deleteUser(id);
        if(deletedUser == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(deletedUser);
    }
}
