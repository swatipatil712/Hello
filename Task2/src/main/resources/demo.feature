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
@tag
Feature: validation for get method

  @tag
  Scenario: validation for get method
  
    
   

 @PostStudentDetails
  Scenario Outline: Fetch student record
  
    Given I Set GET student service api endpoint
    When I send a GET HTTP request
    Then I receive valid response

    Examples: 
      | id  | name | age  |
      | 1 |swati|22|
     
      
    
