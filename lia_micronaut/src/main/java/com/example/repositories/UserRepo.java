package com.example.repositories;

import com.example.entities.User;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User findById(int id);

    void update(@Id int id, String username);
}


