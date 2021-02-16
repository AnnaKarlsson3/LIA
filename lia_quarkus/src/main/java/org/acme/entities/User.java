package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    public String username;
    public String email;
    public String password;

    public static User findByName(String username){
        return find("username", username).firstResult();
    }
}
