Feature: Login Functionality for GitHub

  Background:
    Given I am on the GitHub login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                        |
      | invalid@email.com | invalidPassword | Incorrect username or password.      |
      | abcccc            | validPassword   | Incorrect username or password.      |
      | valid@email.com   | abccc           | Incorrect username or password.      |

  Scenario: Navigating to the forgotten password page
    When I click on the "Forgot password?" link
    Then I should be redirected to the password reset page
