@login
Feature: Login feature

# posative scenario
@smoke
Scenario: user should be loged in with valid creds

Given user launches the url 
When user enters "valid creds"
Then user verifies login is successful
 
# Negative scenario
@sanity 
Scenario Outline: user should not be able to login with invalid creds

Given user launches the url
When user enters "<TCID>"
Then user verifies error message

Examples:
|TCID|
|invalid username|
|invalid password|
|Invalid creds|