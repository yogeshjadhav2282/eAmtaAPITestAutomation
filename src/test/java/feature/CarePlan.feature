@CarePlan
Feature: Verify Care Plan on the Super Admin

  @CreateCarePlan
  Scenario: Verify that the user is able to create care plan
    Given I set up the request structure to create care plan
      | endpoint | care-plan |
    Then I verify that the care plan is created successfully with the 201 status code