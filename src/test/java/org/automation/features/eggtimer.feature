Feature: Clock the egg timer

  @critical
  Scenario Outline:
    Given I navigate to url "<appUrl>"
    Then an egg penguin with a clock should welcome us
    And the title of the egg should be "<title>"

    Examples:
      |appUrl  |title|
      |https://e.ggtimer.com/|e.gg Timer - a simple countdown timer|


  @medium
  Scenario Outline:
    Given the title of the egg should be "<title>"
    When user enters time <time>
    When user clicks on start timer
    And timer should decrement by every second
    Then accept the task complete alert

    Examples:
      | time |title|
      |25    |e.gg Timer - a simple countdown timer|
