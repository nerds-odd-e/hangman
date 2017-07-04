package com.odde.hangman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HangmanController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tries", 12);
        return "index";
    }

    @PostMapping("/")
    public String input(Model model) {
        model.addAttribute("tries", 11);
        return "index";
    }
}
