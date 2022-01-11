Feature: User Account
  Scenario: Validate user is able to login to MyTheresa
  	Given User launches MyTheresa
  	Then Login with email "test123@test123.com"
  	And Validate login was successful