package com.thinkitive.eAmata.stepDefinitions;

import com.thinkitive.eAmata.ApiRequestBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class PatientChartStep extends ApiRequestBuilder {

    @Given("I set up the request structure to add the patient medical details")
    public void i_set_up_the_request_structure_to_add_the_patient_medical_details(Map<String,String>data) {
        String allergy_endpoint = data.get("allergy_endpoint");
        String medication_endpoint = data.get("medication_endpoint");
        String diagnosis_endpoint = data.get("diagnosis_endpoint");
        String tenantId = data.get("tenantId");
        String uuid = data.get("uuid");

        String Allergy_URL = "C:/Users/LNV-24/IdeaProjects/eAmataAPITestAutomation/src/test/resources/AllergyDetails.json";
        String Medication_URL = "C:/Users/LNV-24/IdeaProjects/eAmataAPITestAutomation/src/test/resources/MedicationDetails.json";
        String Diagnosis_URL = "C:/Users/LNV-24/IdeaProjects/eAmataAPITestAutomation/src/test/resources/DiagnosisDetails.json";

        getTenantId(tenantId);
        PostAPI(SuperAdminAccessToken, Allergy_URL, uuid, allergy_endpoint);
        response.prettyPrint();

        getTenantId(tenantId);
        PostAPI(SuperAdminAccessToken,Medication_URL,uuid,medication_endpoint);
        response.prettyPrint();

        Map<String, String> map = new HashMap<>();
        map.put("patientId",uuid);
        map.put("name", "Type 2 Diabetes Mellitus");
        map.put("medicalCode","E11.9");
        map.put("type", "CHRONIC");
        map.put("startDate","2025-06-06");
        map.put("onSetDate", "2025-06-06");
        map.put("note","Patient diagnosed with Type 2 Diabetes Mellitus based on elevated fasting glucose (146 mg/dL) and HbA1c (7.5%). Lifestyle counseling and Metformin initiated.");
        map.put("lastOccurrence", "2025-04-11T13:32:46.936Z");
        map.put("modified","2025-06-11T13:32:46.936Z");
        map.put("modifiedBy", "Dr. Jane Smith");

        getTenantId(tenantId);
        PostAPI(SuperAdminAccessToken,map,diagnosis_endpoint);
        response.prettyPrint();


    }


    @Then("I verify that the medical details is added successfully with status code")
    public void i_verify_that_the_medical_details_is_added_successfully_with_status_code() {
        int expectedStatusCode = 201;
       int actualStatusCode =  response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }
}
