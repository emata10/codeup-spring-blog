package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String postsIndexPage() {
        return "This is the posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable int id) {
        return "Viewing post with ID: " + id;
    }

    @GetMapping("/create/create")
    @ResponseBody
    public String viewCreatePostForm() {
        return "Viewing the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createNewPost() {
        return "Creating a new post";
    }
}