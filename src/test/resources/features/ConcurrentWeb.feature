# new feature
# Tags: optional

Feature: Concurrent Web driver sessions
  @concurrentWeb
  Scenario: run 2 browsers
        Given run 2 browsers
        When click "Yes" to browser 1
        And click "Impressive" to browser 2
        Then the text show successfully