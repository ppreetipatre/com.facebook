@EndToEndTesting
Feature: Test facebook new user functionality

  Scenario: Test facebook register page
    Given User is on facebook page
    Then Capture URL and Title of facebook

  Scenario Outline: Enter new user personal information
    When User on register page
    Then user enter "<firstname>" and "<lastname>" and "<email>" and "<mobileno>"
    Then caputure Screenshot

    Examples: 
      | firstname | lastname | email        | mobileno |
      | aa        | ab       | aa@gmail.com | 23254125 |
      | bb        | ba       | bb@gmail.com | 63254154 |
      | cc        | ca       | cc@gmail.com | 52145623 |
      | dd        | da       | dd@gmail.com |  4521364 |
