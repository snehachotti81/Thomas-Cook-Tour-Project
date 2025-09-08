Feature: User Login on ThomasCook

  @Negative
  Scenario Outline: Login failed with invalid login ID
    Given I am on the ThomasCook login page
    When I enter login details "<loginId>" and send OTP
    And I click on the login button
    Then I should see an error message

    Examples:
      | loginId          |
      | invalidUser1     |
   

  @Positive
  Scenario Outline: Successful login with valid credentials
    Given I am on the ThomasCook login page
    When I enter login details "<loginId>" and send OTP
    And I click on the login button
   # Then I should be logged in successfully

    Examples:
      | loginId                 |
      | snehachhoti29@gmail.com |
