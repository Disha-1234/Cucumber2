Feature: UnsuccessfulLog in

Scenario Outline: unSuccessful log in

Given Browser is open
And User is on login page
When User enters <username>and<password>
And User click on  login in button
Then User is navigated to the home page

  Examples:
    |  |