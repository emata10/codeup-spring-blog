package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {
    @GetMapping("/")
    public String landingPage() {
         return "This is the landing page!";


    }
}




