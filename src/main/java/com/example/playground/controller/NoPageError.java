package com.example.playground.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/error")
public class NoPageError implements ErrorController {

    @GetMapping("")
    public String invalid(HttpServletRequest req, HttpServletResponse res){
        return "Error :(";
    }

}
