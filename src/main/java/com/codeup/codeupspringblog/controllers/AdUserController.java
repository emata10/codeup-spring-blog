package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.AdUser;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class AdUserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private User adUser;


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new AdUser());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute AdUser user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(adUser);
        return "redirect:/login";
    }
}
