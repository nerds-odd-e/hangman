package com.odde.hangman.pages;

import com.odde.hangman.data.GameState;
import com.odde.hangman.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class HomePage {

    @Autowired
    private Driver driver;

    public void open() {
        driver.navigateTo("/");
    }

    public void input(String character) {
        driver.inputTextByName(character, "character");
        driver.clickByText("Guess");
    }

    public void assertAllTextPresent(GameState gameState) {
        driver.waitForTextPresent(gameState.getTries());
        driver.waitForTextPresent(gameState.getLengthOfWord());
        driver.waitForTextPresent(gameState.getUsedChars());
        driver.waitForTextPresent(gameState.getGuessedWord());
    }
}
