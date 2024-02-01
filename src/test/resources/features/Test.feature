# new feature
# Tags: optional

Feature: A description

#    Radio button
  @main
    Scenario Outline: Click Radio Button
      Given Go to Radio Button Page
      When Click "<radio_button_value>"
      Then the text should be: You have selected "<radio_button_value>"
      Examples:
      |radio_button_value|
      |yes               |
      |impressive        |