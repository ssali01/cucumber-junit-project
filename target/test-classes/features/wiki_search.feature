Feature: Wikipedia Search Functionality and verifications

  Background:
    Given User is on Wikipedia home page

  Scenario: Wikipedia Search Functionality Title Verification
    When User types Steve Jobs in the wiki search box
    And User clicks wiki search button
    Then User sees Steve Jobs is in the wiki title


  Scenario: Wikipedia Search Functionality Title Verification
   # Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  Scenario Outline: Wikipedia Search Functionality Title Verification with Data Driven Testing
   # Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title

    Examples:
      | searchValue  | expectedTitle |
      | Steve Jobs   | Steve Jobs    |
      | Bill Gates   | Bill Gates    |
      | Elon Mask    | Elon Mask     |
      | Chuck Norris | Chuck Norris   |
      | Bruce Lee    | Bruce Lee     |
