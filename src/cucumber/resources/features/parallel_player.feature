Feature: Parallel Players

  Scenario: Another player start game when one player already in a game
    Given a player already start a game and input a vowel "a"
    When another player start the game
    Then another player game state as below
      | tries | length of word | used chars | guessed word |
      | 12    | 7              | aeiou      | _ue__a_      |
