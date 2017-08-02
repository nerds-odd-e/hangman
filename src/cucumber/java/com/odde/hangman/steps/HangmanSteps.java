package com.odde.hangman.steps;

import com.odde.hangman.data.GameState;
import com.odde.hangman.driver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HangmanSteps {

    @Autowired
    Driver driver;

    @Given("^the word is \"([^\"]*)\"$")
    public void the_word_is(String arg1) throws Throwable {
    }

    @When("^start game$")
    public void start_game() throws Throwable {
        driver.navigateTo("/");
    }

    @When("^input a vowel \"([^\"]*)\"$")
    public void input_a_vowel(String character) throws Throwable {
        start_game();
        driver.inputTextByName(character, "character");
        driver.clickByText("Guess");
    }

    @Then("^the game state as below$")
    public void the_game_state_as_below(List<GameState> gameStates) throws Throwable {
        GameState gameState = gameStates.get(0);
        driver.waitForTextPresent(gameState.getTries());
        driver.waitForTextPresent(gameState.getLengthOfWord());
        driver.waitForTextPresent(gameState.getUsedChars());
        driver.waitForTextPresent(gameState.getGuessedWord());
    }
}
