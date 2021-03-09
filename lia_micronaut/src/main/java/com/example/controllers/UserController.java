package com.example.controllers;


import com.example.entities.User;
import com.example.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller("/rest/user")
public class UserController {

    @Inject
    UserService userService;

    @Post("/register")
    public HttpResponse registerUser(@RequestBody User user){
        User registerdUser = userService.registerUser(user);
        if(registerdUser == null){
            return HttpResponse.status(HttpStatus.UNPROCESSABLE_ENTITY).body("user already exist");
        }
        return HttpResponse.status(HttpStatus.CREATED).body(registerdUser);
    }

    @Post("/login")
    public HttpResponse loginUser(@RequestBody User user){
        Optional<User> loggedInUser = userService.loginUser(user);
        if(loggedInUser == null){
            return HttpResponse.status(HttpStatus.UNAUTHORIZED).body("wrong email or password");
        }
        return HttpResponse.status(HttpStatus.OK).body(loggedInUser);
    }

    @Get
    public HttpResponse<List<User>> getAllUsers(){
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Put("/{id}")
    public HttpResponse updateUser(@PathVariable(value = "id") int id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        if(updatedUser == null){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("user not found");
        }
        return HttpResponse.status(HttpStatus.OK).body(updatedUser);
    }

    @Delete("/{id}")
    public HttpResponse<String> deleteUser(@PathVariable(value = "id") int id){
        String deletedUser = userService.deleteUser(id);
        if(deletedUser == null){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("user not found");
        }
        return HttpResponse.status(HttpStatus.OK).body(deletedUser);
    }
}
