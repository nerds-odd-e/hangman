package com.odde.hangman;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

@RunWith(NestedRunner.class)
public class HangmanControllerTest {

    public static final int ANY_TRIES = 100;
    public static final int CURRENT_TRIES = 99;
    Hangman mockHangman = mock(Hangman.class);
    HangmanController controller = new HangmanController(mockHangman);
    Model mockModel = mock(Model.class);

    private void givenTriesIs(int value) {
        when(mockHangman.tries()).thenReturn(value);
    }

    public class Input {

        @Test
        public void should_set_tries_when_input_a_char() {
            givenTriesIs(ANY_TRIES);

            input("a");

            verify(mockModel).addAttribute("tries", ANY_TRIES);
        }

        @Test
        public void should_invoke_hangman_input_when_a_char() {
            givenTriesIs(ANY_TRIES);

            input("a");

            verify(mockHangman).input("a");
        }

        private void input(String character) {
            controller.input(mockModel, character, CURRENT_TRIES);
        }

    }

    public class Home {

        @Test
        public void should_set_tries_when_start_game() {
            givenTriesIs(ANY_TRIES);

            home();

            verify(mockModel).addAttribute("tries", ANY_TRIES);
        }

        private String home() {
            return controller.home(mockModel);
        }

    }

}