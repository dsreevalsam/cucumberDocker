Feature: General Validations on Application Launch and Login
  Scenario: Launch website and check for js or url errors
    Given User launches MyTheresa
    Then Check if there are any javascript errors
    And Visit all urls and Validate Status Codes
