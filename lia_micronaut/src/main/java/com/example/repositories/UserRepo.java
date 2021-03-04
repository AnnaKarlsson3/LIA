package com.example.repositories;

import com.example.entities.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findById(int id);
}


