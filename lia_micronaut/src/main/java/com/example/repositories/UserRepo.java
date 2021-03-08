package com.example.repositories;

import com.example.entities.User;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@Repository
@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepo extends CrudRepository<User, Integer> {


    User findByEmail(String email);

    User findById(int id);

    void update(@Id int id, String username);
}


