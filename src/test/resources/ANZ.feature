Feature: ANZ

  Scenario: User calculates borrowing estimates
    Given User navigates to the application URL
    When User enter the values for the field
    | values |
    | 80000   |
    | 10000   |
    | 500     |
    | 0       |
    | 100     |
    | 0       |
    | 10000   |
    And User calculate the borrowing estimate
    Then Verify the calculated borrowing estimate

  Scenario: Clearing the form
    Given User clears the form to start over again

  Scenario: Application unable to estimate without proper values entered
    Given User enters values only for living expenses
    And User calculate the borrowing estimate
    Then User verify the message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
    And User close the browser
