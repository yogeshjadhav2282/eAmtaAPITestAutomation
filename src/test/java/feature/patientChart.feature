@Location
Feature: Verify patient chart Feature


  @AddPatientMedicalDetails
  Scenario Outline: Verify that the user is able to Add patient medical details
    Given I set up the request structure to add the patient medical details
      | uuid                | <UUID>                  |
      | allergy_endpoint    | patient-allergy/bulk    |
      | medication_endpoint | patient-medication/bulk |
      | diagnosis_endpoint  | patient-diagnosis       |
      | tenantId            | qa_scr                  |
    Then I verify that the medical details is added successfully with status code
    Examples:
      | UUID                                 |
      | 3c2e785a-d83c-4183-ae24-22369ec0d4fd |

