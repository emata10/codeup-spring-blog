package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.model.Ad;
import com.codeup.codeupspringblog.model.AdUser;
import com.codeup.codeupspringblog.repositories.AdRepository;
import com.codeup.codeupspringblog.repositories.AdUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class AdController {

    private final AdRepository adDao;
    private final AdUserRepository adUserDao;

    public AdController(AdRepository adDao, AdUserRepository adUserDao) {
        this.adDao = adDao;
        this.adUserDao = adUserDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model){
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAdInDB(@ModelAttribute Ad ad, @RequestParam String message){
        System.out.println(ad.toString());
        AdUser user = adUserDao.getReferenceById(1L);
        ad.setUser(user);
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
