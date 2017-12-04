package com.odde.hangman.steps;

import com.odde.hangman.data.GameState;
import com.odde.hangman.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnotherPlayerSteps {

    @Autowired
    HomePage anotherHomePage;

    @When("^another player start the game$")
    public void another_player_start_the_game() throws Throwable {
        anotherHomePage.open();
    }

    @Then("^another player game state as below$")
    public void another_player_game_state_as_below(List<GameState> gameStates) throws Throwable {
        anotherHomePage.assertAllTextPresent(gameStates.get(0));
    }
}
