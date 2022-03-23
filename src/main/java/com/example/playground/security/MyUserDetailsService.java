package com.example.playground.security;

import com.example.playground.models.User;
import com.example.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        System.out.println(user);
        if(user == null) {
            throw new UsernameNotFoundException("Username does not exist.");
        }
        return new MyUserDetails(user);
    }
}
