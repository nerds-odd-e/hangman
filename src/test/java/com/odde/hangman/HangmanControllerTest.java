package com.odde.hangman;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HangmanControllerTest {
    
    @Test
    public void should_set_tries_when_start_game() {
        Hangman stubHangman = mock(Hangman.class);
        when(stubHangman.tries()).thenReturn(100);
        HangmanController controller = new HangmanController(stubHangman);

        Model mockModel = mock(Model.class);
        controller.home(mockModel);

        verify(mockModel).addAttribute("tries", 100);
    }

}