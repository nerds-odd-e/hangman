package com.odde.hangman;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

@RunWith(NestedRunner.class)
public class HangmanControllerTest {

    private static final int ANY_LENGTH = 10;
    private static final int CURRENT_TRIES = 99;
    private static final int ANY_TRIES = 100;
    Hangman mockHangman = mock(Hangman.class);
    HangmanController controller = new HangmanController(mockHangman);
    Model mockModel = mock(Model.class);

    private void givenGameStateIs(int tries, int length, String usedChars) {
        when(mockHangman.tries()).thenReturn(tries);
        when(mockHangman.length()).thenReturn(length);
        when(mockHangman.usedChars()).thenReturn(usedChars);
    }

    private void verifyAddAttributeForView(int tries, int length, String usedChars) {
        verify(mockModel).addAttribute("tries", tries);
        verify(mockModel).addAttribute("length", length);
        verify(mockModel).addAttribute("usedChars", usedChars);
    }

    public class Input {

        @Test
        public void should_set_game_state_when_input_a_char() {
            givenGameStateIs(ANY_TRIES, ANY_LENGTH, "usedchars");

            input("a");

            verifyAddAttributeForView(ANY_TRIES, ANY_LENGTH, "usedchars");
        }

        @Test
        public void should_invoke_hangman_input_when_a_char() {
            givenGameStateIs(ANY_TRIES, ANY_LENGTH, "usedchars");

            input("a");

            verify(mockHangman).input("a");
        }

        private void input(String character) {
            controller.input(mockModel, character, CURRENT_TRIES);
        }

    }

    public class Home {

        @Test
        public void should_set_game_state_when_start_game() {
            givenGameStateIs(ANY_TRIES, ANY_LENGTH, "usedchars");

            home();

            verifyAddAttributeForView(ANY_TRIES, ANY_LENGTH, "usedchars");
        }

        private String home() {
            return controller.home(mockModel);
        }

    }

}