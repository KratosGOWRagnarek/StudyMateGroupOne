
Feature: Teacher API Test

  @regression
  Scenario: Successfully add a new instructor
    Given the base url is "https://backend.studymate.us"
    And the endpoint path is "/api/instructors"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    And then request content type is "application/json"
    And the request body contains following fields
      | name           | Kelly              |
      | lastName       | Star               |
      | phone          | +1 122 233 3356    |
      | email          | kelly123@gmail.com |
      | specialization | Java               |
    When I send a POST request
    And verify status code is 200
    Then verify response body contains key "message" and value "New student successfully saved"

  @regression
  Scenario: Successfully retrieve all teachers
    Given the base url is "https://backend.studymate.us"
    And the endpoint path is "/api/instructors"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send GET request
    Then verify status code is 200
    Then verify response contains expected text

  Scenario: Successfully delete an instructor by ID
    Given the base url is "https://backend.studymate.us"
    And the endpoint path is "/api/instructors/213"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send DELETE request
    Then verify status code is 200
