package com.odde.hangman;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

@RunWith(NestedRunner.class)
public class HangmanControllerTest {

    Hangman mockHangman = mock(Hangman.class);
    HangmanController controller = new HangmanController(mockHangman);
    Model mockModel = mock(Model.class);

    private void givenStartGameWithTries(int value) {
        when(mockHangman.tries()).thenReturn(value);
    }

    public class Input {

        @Test
        public void should_set_tries_when_input_a_char() {
            givenStartGameWithTries(100);

            input("a");

            verify(mockModel).addAttribute("tries", "100");
        }

        @Test
        public void should_invoke_hangman_input_when_a_char() {
            givenStartGameWithTries(99);

            input("a");

            verify(mockHangman).input("a");
        }

        private void input(String character) {
            controller.input(mockModel, character, 99);
        }

    }

    public class Home {

        @Test
        public void should_set_tries_when_start_game() {
            givenStartGameWithTries(12);

            home();

            verify(mockModel).addAttribute("tries", 12);
        }

        private String home() {
            return controller.home(mockModel, null);
        }

    }

}