package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {

    private final EmailService emailService;
    private final PostRepository postDao;
    private final UserRepository userDao;

    //  *** OLD mapping ***
//    @GetMapping("/posts")
//    public String postsHome(Model model) {
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(new Post(1,"Wow!", "Free Brownies in the quad!"));
//        posts.add(new Post(2,"Uh-oh...", "The brownies betrayed me..."));
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }

    @GetMapping("/posts")
    public String postsHome(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


//    *** Old Mapping ***
//    @GetMapping("/posts/{id}")
//    public String postsHome(@PathVariable long id, Model model) {
//        Post post = new Post(id, "Test post", "Why do all these posts look the same?");
//        model.addAttribute("post", post);
//        return "posts/show";
//    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model) {
        Post post = postDao.findPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String postsEdit(@PathVariable long id, Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        if (user.getId() == post.getUser().getId()) {
            model.addAttribute("message", String.format("Editing Post at ID: %d", post.getId()));
            model.addAttribute("post", post);
            return "posts/create";
        } else {
            return "redirect:/posts";
        }
    }

    @PostMapping("/posts/{id}/edit")
    public String postsUpdate(@ModelAttribute Post post, @PathVariable long id) {
        Post postToUpdate = postDao.findPostById(id);
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setBody(post.getBody());
        postDao.save(postToUpdate);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String postsForm(Model model) {
        model.addAttribute("message", "Create New Post");
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String createPost(@ModelAttribute Post post) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);

        // send email to the creator of the ad
        emailService.sendPostEmail(post,
                "A Post has been created",
                "Here is the post body:\n" + post.getBody());

        return "redirect:/posts";
    }
}
