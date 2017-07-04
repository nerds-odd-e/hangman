package com.odde.hangman.steps;

import com.odde.hangman.driver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Then("^the tries is (\\d+)$")
    public void the_tries_is(int tries) throws Throwable {
        driver.waitForTextPresent(String.valueOf(tries));
    }

    @Then("^the length of word is (\\d+)$")
    public void the_length_of_word_is(int wordLength) throws Throwable {
        driver.waitForTextPresent(String.valueOf(wordLength));
    }

    @Then("^the used chars are \"([^\"]*)\"$")
    public void the_used_chars_are(String used) throws Throwable {
        driver.waitForTextPresent(used);
    }

    @Then("^the guessed word is \"([^\"]*)\"$")
    public void the_guessed_word_is(String guessedWord) throws Throwable {
        driver.waitForTextPresent(guessedWord);
    }
}
