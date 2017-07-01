package com.odde.hangman.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldSteps {

    @When("^view the dashboard$")
    public void view_the_dashboard() throws Throwable {
    }

    @Then("^\"([^\"]*)\" message should be displayed$")
    public void message_should_be_displayed(String message) throws Throwable {
    }
}
