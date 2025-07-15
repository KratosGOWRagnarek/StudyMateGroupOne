Feature: StudyMate Group functionalities

  @createGroup
  Scenario Outline: Create group
    Given User enters valid credentials and logs in
    And User creates group and enters "<groupImagePath>", "<groupName>", "<groupDate>", "<groupDescription>"
    Then validate "<expectedCreatedMessage>"
    Examples:
      | groupImagePath                              | groupName | groupDate  | groupDescription               | expectedCreatedMessage   |
      | src/test/resources/images/codewiseGroup.jpg | Batch9    | 13.01.2025 | All of the students got offers | Group successfully saved |

  @createAndDeleteGroup @smoke
  Scenario Outline: Delete created group
    Given User enters valid credentials and logs in
    And User creates group and enters "<groupImagePath>", "<groupName>", "<groupDate>", "<groupDescription>"
    Then User deletes created "<groupName>" and validates "<expectedDeletedMessage>"
    Examples:
      | groupImagePath                              | groupName | groupDate  | groupDescription               | expectedDeletedMessage            |
      | src/test/resources/images/codewiseGroup.jpg | Batch9    | 13.01.2025 | All of the students got offers | Group successfully moved to trash |
