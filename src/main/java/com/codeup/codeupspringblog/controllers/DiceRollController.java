package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String showRollDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int diceRoll = roll();
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("userGuess", guess);
        model.addAttribute("message", getMessage(guess, diceRoll));
        return "roll-result";
    }

    private int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private String getMessage(int guess, int diceRoll) {
        if (guess == diceRoll) {
            return "Congratulations! You guessed correctly!";
        } else {
            return "Oops! Your guess was incorrect.";
        }
    }
}