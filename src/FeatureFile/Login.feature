Feature: Log in

  Scenario Outline: Successful log in
    Given user is on login page
    When User enter  "<fullname>","<password>"
    And User click on  login button
    Then user should see a validation message "<message>"
    Examples:
      | fullname | password | message|
      | Disha patel| 12345  | Hello Disha patel, let's complete the test form: |



  Scenario Outline: Negative log in
    Given user is on login page
    When User enter  "<fullname>","<password>"
    And User click on  login button
    Then User should see invalidation message"<message>"
    Examples:
      | fullname      | password | message|
      | Disha Patel   |          |Password is invalid|
      | Disha Patel   | 123456   |Password is invalid|
      |               |          |Password is invalid|



  Scenario Outline: user login with blank user name
    Given user is on login page
    When User enter  "<fullname>","<password>"
    And User click on  login button
    Then User should see error message"<message>"
    Examples:
      | fullname | password | message |
      |          | 12345    | Please provide your full name|




