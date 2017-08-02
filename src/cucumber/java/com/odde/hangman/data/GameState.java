package com.odde.hangman.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {

    private String tries;
    private String lengthOfWord;
    private String usedChars;
    private String guessedWord;
}
