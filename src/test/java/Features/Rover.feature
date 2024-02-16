Feature: Mars Rovers
  Check the initialisation poistion
  Check the rover position after movement


  Scenario: Rover direction and positioning initialization
    Given a rover at position 2, 3, "E"
    When the rover's position is initialized
    Then the rover should be at position 2, 3, facing "E"


  Scenario: Rover direction and positioning initialization
    Given a rover at position 1, 4, "N"
    When the rover's position is initialized
    Then the rover should be at position 1, 4, facing "N"

  Scenario: Moving the rover's position and location
    Given a rover at position 2, 2, "N"
    When the rover moves with commands "LMLML"
    Then the rover should be at position 1, 1, facing "E"


  Scenario: Moving the rover as per the given problem scenario
    Given a plateau with upper-right coordinates 5, 5
    And a rover at position 1, 2, "N"
    When the rover moves with commands "LMLMLMLMM"
    Then the rover should be at position 1, 3, facing "N"
