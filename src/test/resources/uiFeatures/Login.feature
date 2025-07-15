@loginFunctionality @regression
Feature: StudyMate Login Functionalities

  @smoke
  Scenario:Verify Successful login with valid credentials
    Given User enters valid credentials and logs in
    Then  verify user is on proper page

  Scenario Outline: Verify choosing Language and successful Login with valid credentials
    Given User chooses "<language>"
    And User enters valid credentials and logs in
    Then  verify user is on proper page
    Examples:
      | language |
      | russian  |
      | english  |

  Scenario Outline: Verify getting error messages for invalid credentials
    Given User chooses "<language>"
    And User enters "<email>" and "<password>"
    Then User should see "<expectedErrorMessage>"
    Examples:
      | language | email              | password | expectedErrorMessage                    |
      | english  |                    | 123456   | Email is required!                      |
      | english  | admin@codewise.com |          | Password is required!                   |
      | english  | invalidemail       | 123456   | Email is not valid!                     |
      | english  | admin@codewise.com | 123      | Password must be at least 6 characters! |
      | russian  |                    | 123456   | Требуется электронный адрес!            |
      | russian  | admin@codewise.com |          | Требуется пароль!                       |
      | russian  | invalidemail       | 123456   | Не валидный электронный адрес!          |
      | russian  | admin@codewise.com | 123      | Введите не менее 6 символов!            |



