package com.odde.hangman;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(NestedRunner.class)
public class HangmanTest {

    HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);

    private Hangman createHangman() {
        return new Hangman(stubHttpServletRequest);
    }

    private void givenRequestWithTries(String tries) {
        when(stubHttpServletRequest.getParameter("tries")).thenReturn(tries);
    }

    public class GameStateSetByRequest {

        @Test
        public void should_be_from_request_if_set() {
            givenRequestWithTries("10");

            assertThat(createHangman().tries()).isEqualTo(10);
        }

        @Test
        public void should_be_initial_state_when_start_game() {
            givenRequestWithTries(null);

            assertThat(createHangman().tries()).isEqualTo(12);
            assertThat(createHangman().length()).isEqualTo(7);
            assertThat(createHangman().usedChars()).isEqualTo("aeiou");
        }
    }

    public class TriesChangeByInput {

        @Test
        public void should_decrease_when_input_a_vowel() {
            Hangman hangman = hangmanWhenGameJustStarted();

            hangman.input("a");

            assertThat(hangman.tries()).isEqualTo(11);
        }

        private Hangman hangmanWhenGameJustStarted() {
            givenRequestWithTries(null);
            return new Hangman(stubHttpServletRequest);
        }

    }

}