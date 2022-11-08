Feature: Google search functionality
  User story: As a user, when I am on google search page
  I should be able to search whatever I want and see relevant information


  Scenario: Search functionality result title verification
    Given User is on Google search page
    When User types apple in the google search box and clicks enter
    Then User sees apple – Google Search is in the google title


  Scenario: Search functionality result title verification
    Given User is on Google search page
    When User types "tesla" in the google search box and clicks enter
    Then User sees "tesla - Google Search" is in the google title