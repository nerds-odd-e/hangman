package com.odde.hangman;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HangmanTest {

    @Test
    public void tries_should_be_12_when_start_game() {
        Hangman hangman = new Hangman();

        assertThat(hangman.tries()).isEqualTo(12);
    }

}