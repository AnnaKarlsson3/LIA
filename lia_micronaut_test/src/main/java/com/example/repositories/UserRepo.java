package com.example.repositories;

import com.example.entities.User;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
@Introspected
public interface UserRepo extends CrudRepository<User, Integer> {
}
