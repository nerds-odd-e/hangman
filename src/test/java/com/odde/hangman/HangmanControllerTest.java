package com.odde.hangman;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class HangmanControllerTest {

    Hangman mockHangman = mock(Hangman.class);
    HangmanController controller = new HangmanController(mockHangman);
    Model mockModel = mock(Model.class);

    @Test
    public void home_should_set_tries_when_start_game() {
        givenStartGameWithTries(100);

        home();

        verify(mockModel).addAttribute("tries", 100);
    }

    @Test
    public void input_should_set_tries_when_input_a_char() {
        givenStartGameWithTries(100);

        input("a");

        verify(mockModel).addAttribute("tries", 100);
    }

    @Test
    public void input_should_invoke_hangman_input_when_a_char() {
        givenStartGameWithTries(99);

        input("a");

        verify(mockHangman).input("a");
    }

    private void input(String character) {
        controller.input(mockModel, character);
    }

    private void givenStartGameWithTries(int value) {
        when(mockHangman.tries()).thenReturn(value);
    }

    private String home() {
        return controller.home(mockModel);
    }

}