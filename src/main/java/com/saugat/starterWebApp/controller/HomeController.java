package com.saugat.starterWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String message(){
        return "Welcome to Home Page!";
    }
    @RequestMapping("/about")
    public String about(){
        return "This is the About Page.";
    }

}
