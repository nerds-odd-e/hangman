package com.odde.hangman;

import org.springframework.stereotype.Component;

@Component
public class Hangman {

    private int tries = 12;

    public int tries() {
        return tries;
    }

    public void input(String character) {
        tries--;
    }

    public void setTries(int tries) {

    }
}
