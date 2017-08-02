package com.odde.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HangmanController {

    private final Hangman hangman;

    @Autowired
    public HangmanController(Hangman hangman) {
        this.hangman = hangman;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tries", hangman.tries());
        return "index";
    }

    @PostMapping("/")
    public String input(Model model, String character, int tries) {
        hangman.input(character);
        return home(model);
    }
}
