Feature: get a specific actor.

Scenario Outline: getting a specific actor from DB
    Given an actor exists with id <ActorID>
    When I request an actors details
    Then the webpage should show the actors "<first_name>" and "<last_name>"
    Examples:
    |ActorID|first_name|last_name|
    |1      |PENELOPE  |GUINESS  |
    |5      |JOHNNY    |LOLLOBRIGIDA|