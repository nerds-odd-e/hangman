Feature: Hangman

  Scenario: Start Game
    Given the word is "tuesday"
    When start game
    Then the tries is 12
    And the length of word is 7
    And the used chars are "aeiou"
    And the guessed word is "_ue__a_"

  Scenario: Input a vowel
    Given the word is "tuesday"
    When input a vowel "a"
    Then the tries is 11
    And the length of word is 7
    And the used chars are "aeiou"
    And the guessed word is "_ue__a_"
