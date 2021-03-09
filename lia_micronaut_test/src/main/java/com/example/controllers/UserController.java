package com.example.controllers;

import com.example.entities.User;
import com.example.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;

@Controller("/rest/user")
public class UserController {

    @Inject
    UserService userService;

    @Get
    public HttpResponse<List<User>> getAllUsers(){
        return HttpResponse.ok(userService.getAllUsers());
    }
}
