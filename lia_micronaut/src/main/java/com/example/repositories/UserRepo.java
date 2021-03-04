package com.example.repositories;

import com.example.entities.User;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    @Executable
    User findByEmail(String email);
    @Executable
    User findById(int id);
}


