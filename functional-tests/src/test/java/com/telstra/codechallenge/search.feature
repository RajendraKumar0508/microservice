# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve some spring boot  and searchUser

  Scenario: Get all search repositories
    Given url microserviceUrl
    And path '/search/repositories'
    And params {"q":["tetris+language:Swift"]}
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation    
    # def quoteSchema = {  html_url : '#string',watchers_count : '#number' ,language : '#string',name : '#string'} 
    And match response[*].language contains ['Swift']
    
    
    
    Scenario: Get all search User
    Given url microserviceUrl
    And path '/search/users'
    And params {"q":["tom+repos:%3E42+followers:%3E1000"]}
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation    
  * match each response[*].login == '#string'

