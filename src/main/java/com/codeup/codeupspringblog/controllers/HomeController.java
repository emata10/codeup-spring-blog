package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String returnHomePage() {
//        return "This is the landing page!";
//    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }



}