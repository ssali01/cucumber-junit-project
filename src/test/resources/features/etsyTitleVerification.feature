Feature: Etsy Title Verification
  User story: As a user I am on etsy page,
  I should be able to see the title of the page


  Scenario: Etsy title verification
    Given User is on "https://www.etsy.com" page
    When User sees title is as expected.
    Then User sees "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone" in the title of the page


