package com.example.playground.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Content> content;

    public User(String username){
        this.username = username;
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public List<Content> getContent() {
        return content;
    }

    public String toString(){
        return "Username: " + this.username + ", Pass: "+ this.password;
    }

    public void addContent(Content contentItem){
        content.add(contentItem);
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
