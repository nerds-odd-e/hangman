package com.odde.hangman;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class HangmanTest {

    HttpServletRequest mockHttpServletRequest = mock(HttpServletRequest.class);
    Hangman hangman = new Hangman(mockHttpServletRequest);

    @Test
    public void tries_should_be_12_when_start_game() {
        assertThat(hangman.tries()).isEqualTo(12);
    }
    
    @Test
    public void tries_should_be_11_when_input_a_vowel() {
        hangman.input("a");

        assertThat(hangman.tries()).isEqualTo(11);
    }

}