Feature: Booking search test

  Scenario: Search for the hotel and validate the rating
    Given I am at Booking.com page
    When I set 'Hilton Head Island' in the search bar
    And I click 'Hilton Head Island' in the dropdown menu
    And I click the search button
    Then 'The Westin Hilton Head Island Resort & Spa'  should be present
    Then The hotel should have score '8.0'