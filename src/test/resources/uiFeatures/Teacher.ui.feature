@regression
Feature: Test StudyMate Functionality

  Scenario: User is adding a new teacher to the table
    Given User enters valid credentials and logs in
    Then verify user is on proper page

  Scenario Outline: Add teachers with scenario outline
    Given User enters valid credentials and logs in
    And  verify user is on proper page
    When user adds teacher by '<name>','<lastname>','<phone>','<email>','<specialization>'
    And the User submits the form
    And The new teacher should appear in the teachers list
    Then User deletes the teacher
    Examples:
      | name  | lastname | phone           | email              | specialization |
      | Kelly | Star     | +1 122 233 3356 | kelly123@gmail.com | Java           |
      | Kelly | Bob   | +1 122 233 3356 | big231I@gmail.com   | Java           |