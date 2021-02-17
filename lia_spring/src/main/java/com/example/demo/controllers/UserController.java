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

        if(userService.registerUser(user) == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("user already exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user){
        if(userService.loginUser(user) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong email or password");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
