package com.todolist.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
  
    @Id                             
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;

    private String name;
    private String username;
    private String password;
    private String role;
    private boolean active;

    @OneToMany(mappedBy = "author")
    private Set<ToDo> toDos;

    //No Arg Constructor
    public User() {}

    //Constructor
    public User(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.role = userRole;
        this.active = true;
    }
    //Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {                               
    if (this == o) return true;                                     
        if (o == null || getClass() != o.getClass()) return false;  
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + username + '\'' +
                ", lastName='" + password + '\'' +
                ", toDos=" + toDos +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}