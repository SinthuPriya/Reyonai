@FlightBooking 
Scenario Outline: Description of the scenario

    Given the user is on the Ryanair homepage
    When the user selects the departure airport as "<departure>"
    And the user selects the destination airport as "<destination>"
    And the user selects the departure date as "<departureDate>"
    And the user selects the return date as "<returnDate>"
    And the user selects the number of passengers as "<passengerCount>"
    And the user searches for available flights
    Then the user should see a list of available flights
 
 
 Examples:
 
 |departure     |destination     |departureDate |returnDate     |PassengerCount|
 |London        |paris           |2024-03-01    | 2024-03-02    | 2            |
 |NewYork       |Barcelon        |2024-03-15    | 2024-03-16    | 2            |
 
 
