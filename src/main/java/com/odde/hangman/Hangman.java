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
    private String usedChars;

    @Autowired
    public Hangman(HttpServletRequest request) {
        setTriesByRequest(request);
    }

    private void setTriesByRequest(HttpServletRequest request) {
        initUsedChars(request);
        initTries(request);
    }

    private void initTries(HttpServletRequest request) {
        if (triesOf(request) == null)
            tries = 12;
        else
            tries = parseInt(triesOf(request));
    }

    private void initUsedChars(HttpServletRequest request) {
        if (usedCharsOf(request) == null)
            usedChars = "aeiou";
        else
            usedChars = usedCharsOf(request);
    }

    private String usedCharsOf(HttpServletRequest request) {
        return request.getParameter("usedChars");
    }

    private String triesOf(HttpServletRequest request) {
        return request.getParameter("tries");
    }

    public int tries() {
        return tries;
    }

    public void input(String character) {
        tries--;
       
        if (!usedChars.contains(character))
            usedChars += character;
    }

    public int length() {
        return 7;
    }

    public String usedChars() {
        return usedChars;
    }
}
