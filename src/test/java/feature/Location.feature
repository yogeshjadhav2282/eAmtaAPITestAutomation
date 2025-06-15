@Location
Feature: Verify Location Feature

  @Regression
  @AddLocationWithValidDetails
  Scenario: Verify that the user is able to Add Location
    Given I set up the request structure to add the Location
      | endpoint | location |
      | tenantId | NotValue |
#    we have not assigned value to the tenant id so as 'NotValue' mentioned, beacause we can not pass the Null values
    Then I verify that the Location is added successfully with 201 status code

  @Regression
  @getTheLocationList
  Scenario: Verify that the user is able to see the staff list
    Given I set up the request structure to see the Location list
      | endpoint      | location |
      | tenantId      | NotValue |
      | page          | 0        |
      | size          | 20       |
      | sortBy        | created  |
      | sortDirection | desc     |
    Then I verify that the Location list is displayed successfully with 200 status code

  @editLocationWithValidDetails
  Scenario: Verify that the user is able to edit the staff details
    Given I set up the request structure to edit the Location details
      | endpoint | location |
      | tenantId | NotValue |
    Then I verify that the Location is edited successfully with 200 status code


  @getLocationDetailsByValidUUID
  Scenario: Verify that the user is able to view the Location details
    Given I set up the request structure to view the Location details
      | endpoint | location                             |
      | tenantId | NotValue                             |
      | uuid     | bf57b7b8-016b-42f0-8618-7684846b1d0d |
    Then I verify that the Location details displayed successfully with 200 status code