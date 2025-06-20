package com.thinkitive.eAmata.stepDefinitions;

import com.github.javafaker.Faker;
import com.thinkitive.eAmata.ApiRequestBuilder;
import entities.Pojo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CarePlanStep extends ApiRequestBuilder {
    Faker faker = new Faker();
    private String endpoint;
    private Response response;


    @Given("I set up the request structure to create care plan")
    public void iSetUpTheRequestStructureToCreateCarePlan(Map<String,String> data) {
        endpoint = data.get("endpoint");


        CarePlanPojo carePlan = CarePlanPojo.builder()
                .title("Post-Surgery Recovery Care.")
                .duration(2)
                .durationUnit("MONTH")
                .gender("MALE")
                .overview("This care plan is designed to manage your hypertension through lifestyle changes and medications to achieve a Blood glucose normal level and reduce the risk of complications.")
                .ageCriteria("Older than")
                .age("50")
                .diagnosisCodes(DiagnosisCodes.getDiagnosisCodes())
                .deviceName(DeviceNames.getDeviceNames())
                .vitalReferences(VitalRange.getVitalRanges())
                .programGoals(ProgramGoals.getProgramGoals())
                .protocolType("OUT_OF_RANGE_BP")
                .build();


        ApiRequestBuilder.PostAPI(SuperAdminAccessToken, carePlan, endpoint);
        response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Care Plan is added successfully with {int} status code")
    public void iVerifyThatTheCarePlanIsAddedSuccessfullyWithStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        // Optionally, assert on response message or data

    }

    @Then("I verify that the care plan is created successfully with the {int} status code")
    public void iVerifyThatTheCarePlanIsCreatedSuccessfullyWithTheStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
