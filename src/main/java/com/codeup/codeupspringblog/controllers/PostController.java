package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String postsHome(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"Wow!", "Free Brownies in the quad!"));
        posts.add(new Post(2,"Uh-oh...", "The brownies betrayed me..."));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model) {
        Post post = new Post(id, "Test post", "Why do all these posts look the same?");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsForm() {
        return "And this is where the form for creating a post would go... IF WE HAD ONE!";
    }
    @PostMapping("/posts/create")
    public void createPost() {
        //Something happens here to store a post for later ;)
    }
}