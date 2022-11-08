Feature: Etsy Search Functionality Title Verification (without parameterization)
  User story: As a user, when I am on etsy search page
  I should be able to search Wooden Spoon and see it in the title

  Background:
    Given User is on "https://www.etsy.com" page


  Scenario: Etsy Search functionality result title verification
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden Spoon" is in the title

