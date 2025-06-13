@ProviderGroup
Feature: Verify Provider Group Feature

  @Regression
  @AddProviderGroupWithValidDetails
  Scenario: Verify that the user is able to Add Provider Group
    Given I set up the request structure to add the Provider Group
      | endpoint | provider-group |
    Then I verify that the Provider Group is added successfully with 201 status code

  @Regression
  @getTheProviderGroupList
  Scenario: Verify that the user is able to see the staff list
    Given I set up the request structure to see the Provider Group list
      | endpoint      | provider-group |
      | page          | 0              |
      | size          | 10             |
      | sortBy        | created        |
      | sortDirection | desc           |
    Then I verify that the Provider Group list is displayed successfully with 200 status code

  @editProviderGroupWithValidDetails
  Scenario: Verify that the user is able to edit the staff details
    Given I set up the request structure to edit the Provider Group details
      | endpoint | provider-group |
    Then I verify that the Provider Group is edited successfully with 200 status code


  @getProviderGroupDetailsByValidUUID
  Scenario: Verify that the user is able to view the Provider Group details
    Given I set up the request structure to view the Provider Group details
      | endpoint | provider-group                       |
      | uuid     | bf57b7b8-016b-42f0-8618-7684846b1d0d |
    Then I verify that the Provider Group details displayed successfully with 200 status code