package com.example.playground.controller;

import com.example.playground.models.Content;
import com.example.playground.models.User;
import com.example.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> getUsers(HttpServletResponse res){
        res.setStatus(202);
        return userService.getUsers();
    }

    @GetMapping(value="/{username}")
    public User getUser(@PathVariable(value = "username") String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping(value ="/{username}/add")
    public ResponseEntity<User> addContent(@PathVariable(value="username") String username, @RequestBody Content content){
        System.out.println(username);
        System.out.println(content);
        User user = userService.addUserContent(username, content);
        int status = user == null?500:201;
        return ResponseEntity.status(status).body(user);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user, HttpServletResponse res){
        boolean success = userService.addUser(user);
        System.out.println("Adding: " + user.getUsername() + (success? "(success)":"(failed)"));
        if(success){
            res.setStatus(201);
        }else{
            res.setStatus(500);
        }
    }

}
