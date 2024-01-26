# new feature
# Tags: optional

  @bookstore
Feature: Bookstore test

  Background: : Test login Page
    Given Go to Login Page
    When fill UserName "phong" and password "1Qaz2Wsx!@#"
    And click Login button
    Then Login successful

  Scenario Outline: Test Add Book To Profile
    Given Go to books list Page
    When click on "<bookName>"
    And click "Add to your collection" button
    And click ok on Alert popup
    And click on Profile Link
    Then "<bookName>" appeared on profile Page
    Examples:
    | bookName          |
    | Git Pocket Guide  |
    | You Don't Know JS |
