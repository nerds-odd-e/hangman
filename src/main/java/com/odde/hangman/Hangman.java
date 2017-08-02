package com.odde.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Component
@RequestScope
public class Hangman {

    private int tries = 12;

    @Autowired
    public Hangman(HttpServletRequest request) {
        if (request.getParameter("tries") == null)
            tries = 12;
        else
            tries = Integer.parseInt(request.getParameter("tries"));
    }

    public int tries() {
        return tries;
    }

    public void input(String character) {
        tries--;
    }

    public void setTries(int tries) {

    }
}
