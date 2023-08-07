package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;


@Controller
public class PostController {

    @GetMapping("/posts")
    public String viewAllPosts(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Hello Everyone"));
        posts.add(new Post("My dogs name is loki"));

        model.addAttribute("posts", posts);

        return "posts/index"; // This will map to templates/posts/index.html
    }

    @GetMapping("/posts/{postId}")
    public String viewPost(Model model, @PathVariable int postId) {
        Post post = new Post("Sample Title");
        model.addAttribute("post", post);

        return "posts/show"; // This will map to templates/posts/show.html
    }
}
