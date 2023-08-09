package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Ad;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.AdRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class AdController {

    private final AdRepository adDao;

    private final UserRepository userDao;

    public AdController(AdRepository adDao, UserRepository userDao) {
        this.adDao = adDao;
        this.userDao = userDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String createAdForm(){
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAdInDB(@RequestParam(name="title") String title, @RequestParam(name="description") String description){
        User user = userDao.findUserById(1L);
        Ad ad = new Ad(title, description, user);
        adDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model){
        Ad ad = adDao.findAdById(id);
        model.addAttribute("ad", Objects.requireNonNullElseGet(ad, () -> new Ad("not found", "could not find that ad")));
        return "ads/show";
    }

}