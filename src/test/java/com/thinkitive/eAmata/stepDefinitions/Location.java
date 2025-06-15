package com.thinkitive.eAmata.stepDefinitions;

import com.thinkitive.eAmata.propertyHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.github.javafaker.Faker;
import com.thinkitive.eAmata.ApiRequestBuilder;

import io.cucumber.datatable.DataTable;

import java.util.Map;

import org.junit.Assert;

import java.util.HashMap;

public class Location extends ApiRequestBuilder {
    Map<String, Object> payload = new HashMap<>();
    Map<String, String> address = new HashMap<>();


    @Given("I set up the request structure to add the Location")
    public void iSetUpTheRequestStructureToAddTheLocation(Map<String, String> data) {
        if (!data.get("TenantId").equals("NotValue")) {
            TenantId = data.get("TenantId");
        }

        Faker faker = new Faker();
        String endpoint = data.get("endpoint");
        String LocationName = faker.address().city();

        payload.put("name", LocationName);
        payload.put("phone", "+1" + faker.number().digits(10));
        payload.put("timezone", "string");
        payload.put("email", LocationName + "@yopmail.com");

        address.put("line1", faker.address().streetAddress());
        address.put("line2", "Dwarf street");
        address.put("city", "Jackson");
        address.put("state", "Arizona");
        address.put("country", "USA");
        address.put("zipcode", "12346");

        payload.put("address", address);
        request.header("x-tenant-id", TenantId);
        ApiRequestBuilder.PostAPI(SuperAdminAccessToken, payload, endpoint);
        this.response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Location is added successfully with {int} status code")
    public void iVerifyThatTheLocationIsAddedSuccessfullyWith201StatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertEquals("Location added successfully.", response.jsonPath().get("message"));
    }

    @Given("I set up the request structure to see the Location list")
    public void iSetUpTheRequestStructureToSeeTheLocationList(Map<String, String> data) {
        String endpoint = data.get("endpoint");
        if (!data.get("tenantId").equals("NotValue")) {
            TenantId = data.get("tenantId");
        }

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("size", data.get("size"));
        queryParams.put("page", data.get("page"));
        queryParams.put("sortBy", data.get("sortBy"));
        queryParams.put("sortDirection", data.get("sortDirection"));

        if(!data.get("tenantId").equals("NotValue")){
            TenantId = data.get("tenantId");
        }

       // getTenantId(TenantId);
        ApiRequestBuilder.GetAPI(SuperAdminAccessToken, queryParams, endpoint);
        this.response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Location list is displayed successfully with {int} status code")
    public void iVerifyThatTheLocationListIsDisplayedSuccessfullyWith200StatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        Assert.assertNotNull(ApiRequestBuilder.response.getBody());
    }

    @Given("I set up the request structure to edit the Location details")
    public void iSetUpTheRequestStructureToEditTheLocationDetails(Map<String, String> data) {
        String endpoint = data.get("endpoint");
        if (!data.get("TenantId").equals("NotValue")) {
            TenantId = data.get("TenantId");
        }

        payload.put("uuid", "67da1b75-6de5-4dff-8f85-d42644a48729");
        payload.put("name", "Cape Coral");
        payload.put("phone", "+13475867458");
        payload.put("email", "scr@yopmail.com");

        request.header("x-tenant-id", TenantId);
        ApiRequestBuilder.PutAPI(SuperAdminAccessToken, payload, endpoint);
        this.response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Location is edited successfully with {int} status code")
    public void iVerifyThatTheLocationIsEditedSuccessfullyWith200StatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertEquals("Location updated successfully.", response.jsonPath().get("message"));
    }

    @Given("I set up the request structure to view the Location details")
    public void iSetUpTheRequestStructureToViewTheLocationDetails(Map<String, String> data) {
        String endpoint = data.get("endpoint");
        if (!data.get("TenantId").equals("NotValue")) {
            TenantId = data.get("TenantId");
        }
        String uuid = data.get("uuid");

        request.header("x-tenant-id", TenantId);
        ApiRequestBuilder.GetByIdAPI(SuperAdminAccessToken, uuid, endpoint);
        this.response = ApiRequestBuilder.response;

    }

    @Then("I verify that the Location details displayed successfully with {int} status code")
    public void iVerifyThatTheLocationDetailsDisplayedSuccessfullyWith200StatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertNotNull(response.getBody());
    }
}
