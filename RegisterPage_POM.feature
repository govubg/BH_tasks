
Feature: Verifying RagaloCasila Details

  Background: 
    Given User is on RagaloCasila home page
 
  Scenario: Verifying the register functionality with valid credentials.
    When User clicks on create an account 
    And User enetrs necessary details
    Then User should click Continue Button.
    Then User should click Continue 
    When User clicks on Change Password
    And User enetrs new password and confrim password
    When User should click Continue Button.
    Then Success message appears
    When User should logout 
    Then User should login with new password