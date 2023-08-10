package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.model.PostForm;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class PostController {


    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

//    @GetMapping("/posts")
//    public String postsHome(Model model) {
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(new Post(1,"Wow!", "Free Brownies in the quad!"));
//        posts.add(new Post(2,"Uh-oh...", "The brownies betrayed me..."));
//        model.addAttribute("posts", posts);
//        return "posts/index";
//}

    @GetMapping("/posts")
    public String postsHome(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    //
//    @GetMapping("/posts/{id}")
//    public String postsHome(@PathVariable long id, Model) {
//        Post = new Post(id, "Test post", "Why do all these posts look the same?");
//        model.addAttribute("post", post);
//        return "posts/show";
//    }
    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model) {
        Post post = postDao.findPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsForm(Model model) {
        model.addAttribute("heading", "Create new post.");
        model.addAttribute("postForm", new PostForm());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        User user = userDao.findById(1L).orElse(null);
        if (user != null) {
            post.setUser(user);
            postDao.save(post);
        }
        return "redirect:/posts";
    }

}



