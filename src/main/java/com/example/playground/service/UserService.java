package com.example.playground.service;

import com.example.playground.models.User;
import com.example.playground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user){
        boolean success = false;
        try{
            success = userRepository.save(user) != null;
        }catch(Exception e){
            System.out.println("Tried adding username: " + user.getUsername() +"(ERROR)\n" + e.getMessage());
        }
        return success;
    }


}
