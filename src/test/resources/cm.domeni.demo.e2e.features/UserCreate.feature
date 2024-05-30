Feature: User Creation

  Scenario: Create a new User
    When    I create a new business with the following data
      | user name                      | first name            | last name          |
      | implement test e2e create user | businessCreation_name | last name e2e test |
    Then     I should see that the message with the following data have been created
      | time | owner                                | contextId   | content          | content type      | objectType |
      | now  | 5a6b6d5a-535d-4136-8fd4-fe2529209a26 | id business | has been created | BUSINESS_CREATION | BUSINESS   |