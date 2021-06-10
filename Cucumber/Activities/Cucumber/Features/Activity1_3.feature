#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@activity1_3
Feature: Testing with Tags


 @SimpleAlert @SmokeTest
Scenario: Test for Simple Alert
    Given User is on the page 
    When User clicks the Simple Alert button 
    Then Alert opens
    And Read the text from it and print it
    And Close the alert
    And Close Browser

@ConfirmAlert
Scenario: Test for Confirm Alert
    Given User is on the page
    When User clicks the Confirm Alert button 
    Then Alert opens
    And Read the text from it and print it
    And Close the alert with Cancel
    And Close Browser
	
@PromptAlert
Scenario: Test for Prompt Alert
    Given User is on the page
    When User clicks the Prompt Alert button 
    Then Alert opens
    And Read the text from it and print it
    And Write a custom message in it
    And Close the alert
    And Close Browser