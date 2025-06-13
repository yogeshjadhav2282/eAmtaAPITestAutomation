Feature: Verify login Functionality

  @Regression
    @ValidUsernameAndPasswordForSuperAdmin
  Scenario Outline: Verify user is able to login on the super admin Portal
    Given I set up the structure to login User
      | endpoint | login      |
      | username | <Email>    |
      | password | <Password> |
    Then I verify that the user is able to login on the super admin portal successfully
      | scenario | <Scenario> |
    Examples:
      | Scenario          | Email                                    | Password |
      | ValidCredentials  | yogesh.jadhav+superadmin2@thinkitive.com | Test@123 |
      | EmailDoesNotExist | yogesh.jadhav+548465262@thinkitive.com   | Test@123 |
      | invalidEmail      | yogesh.jadhavthinkitive.com              | Test@123 |
      | invalidPassword   | yogesh.jadhav+superadmin2@thinkitive.com | Test123  |
      | BlankCredentials  | Null                                     | Null     |

