Feature: Hangman

  Scenario: Start Game
    Given the word is "tuesday"
    When start game
    Then the game state as below
      | tries | length of word | used chars | guessed word |
      | 12    | 7              | aeiou      | _ue__a_      |

  Scenario: Input a vowel
    Given the word is "tuesday"
    When input a character "a"
    Then the game state as below
      | tries | length of word | used chars | guessed word |
      | 11    | 7              | aeiou      | _ue__a_      |

  Scenario: Input a wrong consonant
    Given the word is "tuesday"
    When input a character "c"
    Then the game state as below
      | tries | length of word | used chars | guessed word |
      | 11    | 7              | aeiouc     | _ue__a_      |
