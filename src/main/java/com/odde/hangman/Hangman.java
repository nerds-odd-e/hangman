package com.odde.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Integer.parseInt;

@Component
@RequestScope
public class Hangman {

    private int tries;

    @Autowired
    public Hangman(HttpServletRequest request) {
        setTriesByRequest(request);
    }

    private void setTriesByRequest(HttpServletRequest request) {
        if (triesOf(request) == null)
            tries = 12;
        else
            tries = parseInt(triesOf(request));
    }

    private String triesOf(HttpServletRequest request) {
        return request.getParameter("tries");
    }

    public int tries() {
        return tries;
    }

    public void input(String character) {
        tries--;
    }

    public int length() {
        return 7;
    }

    public String usedChars() {
        return "aeiou";
    }
}
