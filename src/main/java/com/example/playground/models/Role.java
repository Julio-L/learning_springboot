package com.example.playground.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long role_id;

    @Column(unique = true)
    private String role;

    @JsonIgnore
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    @ManyToMany
    List<User> users;

    public long getRole_id() {
        return role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
