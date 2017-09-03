package com.odde.hangman.steps;

import com.odde.hangman.Application;
import com.odde.hangman.data.GameState;
import com.odde.hangman.driver.Driver;
import com.odde.hangman.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ContextConfiguration(classes = {Application.class})
public class HangmanSteps {

    @Autowired
    HomePage homePage;

    @Autowired
    Driver anotherDriver;

    @Given("^the word is \"([^\"]*)\"$")
    public void the_word_is(String arg1) throws Throwable {
    }

    @Given("^a player already start a game and input a vowel \"([^\"]*)\"$")
    public void a_player_already_start_a_game_and_input_a_vowel(String character) throws Throwable {
        input_a_vowel(character);
    }

    @When("^another player start the game$")
    public void another_player_start_the_game() throws Throwable {
        anotherDriver.navigateTo("/");
    }

    @When("^start game$")
    public void start_game() throws Throwable {
        homePage.open();
    }

    @When("^input a vowel \"([^\"]*)\"$")
    public void input_a_vowel(String character) throws Throwable {
        start_game();
        homePage.input(character);
    }

    @Then("^the game state as below$")
    public void the_game_state_as_below(List<GameState> gameStates) throws Throwable {
        homePage.assertAllTextPresent(gameStates.get(0));
    }

    @Then("^another player game state as below$")
    public void another_player_game_state_as_below(List<GameState> gameStates) throws Throwable {
        anotherDriver.waitForTextPresent(gameStates.get(0).getTries());
    }
}
