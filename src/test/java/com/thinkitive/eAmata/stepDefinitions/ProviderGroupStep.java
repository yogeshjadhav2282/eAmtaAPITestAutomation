package com.thinkitive.eAmata.stepDefinitions;

import com.github.javafaker.Faker;
import com.thinkitive.eAmata.ApiRequestBuilder;
import entities.Pojo.Address;
import entities.Pojo.ProviderGroup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class ProviderGroupStep extends ApiRequestBuilder{
    private String endpoint;
    private String createdProviderGroupUUID;
    private Response response;

    @Given("I set up the request structure to add the Provider Group")
    public void iSetUpTheRequestStructureToAddTheProviderGroup(Map<String, String> data) {
        endpoint = data.get("endpoint").toString();
        Faker faker = new Faker();

        // Generation of the subdomain by the Provider Group Name
        String Subdomain = "";
        String PGName = faker.medical().hospitalName();
        System.out.println(PGName);
        String[] words = PGName.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                System.out.println(word);
                String ch = String.valueOf(word.charAt(0)).toLowerCase();
                Subdomain += ch;
            }
        }
        //System.out.println(Subdomain);


        Address address = new Address();
        address.setLine1(faker.address().streetAddress());
        address.setLine2("a1 street");
        address.setCity("Akutan");
        address.setState("Arizona");
        address.setCountry("USA");
        address.setZipcode("98709");

        ProviderGroup pg = ProviderGroup.builder()
                .name(PGName)
                .subdomain(Subdomain)
                .email(Subdomain + "@yopmail.com")
                .phone("+1" + faker.phoneNumber().subscriberNumber(10))
                .npi(faker.number().digits(10))
                .address(address)
                .build();

        ApiRequestBuilder.PostAPI(SuperAdminAccessToken, pg, endpoint);
        this.response = ApiRequestBuilder.response;

    }

    @Then("I verify that the Provider Group is added successfully with {int} status code")
    public void iVerifyThatTheProviderGroupIsAddedSuccessfullyWithStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        String expectedMessage = "Provider group is created successfully.";
        String actualMessage = response.jsonPath().getString("message");

        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertEquals(expectedMessage,actualMessage);
    }



    @Given("I set up the request structure to see the Provider Group list")
    public void iSetUpTheRequestStructureToSeeTheProviderGroupList(Map<String, String> data) {
        endpoint = data.get("endpoint").toString();

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("page", data.get("page"));
        queryParams.put("size", data.get("size"));
        queryParams.put("sortBy", data.get("sortBy"));
        queryParams.put("sortDirection", data.get("sortDirection"));

        ApiRequestBuilder.GetAPI(SuperAdminAccessToken, queryParams, endpoint);
        this.response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Provider Group list is displayed successfully with {int} status code")
    public void iVerifyThatTheProviderGroupListIsDisplayedSuccessfullyWithStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertNotNull(response.jsonPath().get("data"));
    }

    @Given("I set up the request structure to edit the Provider Group details")
    public void iSetUpTheRequestStructureToEditTheProviderGroupDetails(Map<String, String> data) {
        endpoint = data.get("endpoint").toString();
        String PGJsonUrl = "C:/Users/LNV-24/IdeaProjects/eAmataAPITestAutomation/src/test/resources/ProviderGroup.json";

        ApiRequestBuilder.PutAPI(SuperAdminAccessToken, PGJsonUrl, endpoint);
        this.response = ApiRequestBuilder.response;

    }

    @Then("I verify that the Provider Group is edited successfully with {int} status code")
    public void iVerifyThatTheProviderGroupIsEditedSuccessfullyWithStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        String expectedMessage = "Provider group updated successfully.";
        String actualMessage = response.jsonPath().get("message");

        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Given("I set up the request structure to view the Provider Group details")
    public void iSetUpTheRequestStructureToViewTheProviderGroupDetails(Map<String, String> data) {
        endpoint = data.get("endpoint").toString();
        String uuidFromFeature = data.get("uuid");

        String uuidToUse = (uuidFromFeature != null && !uuidFromFeature.isEmpty()) ? uuidFromFeature : createdProviderGroupUUID;  // for now we have not createdProviderGroupUUID but we can generate from the list API

        if (uuidToUse == null) {
            Assert.fail("UUID for Provider Group is not available for viewing. Ensure a Provider Group was added or provide a valid UUID.");
        }

        ApiRequestBuilder.GetByIdAPI(SuperAdminAccessToken, uuidToUse, endpoint);
        this.response = ApiRequestBuilder.response;
    }

    @Then("I verify that the Provider Group details displayed successfully with {int} status code")
    public void iVerifyThatTheProviderGroupDetailsDisplayedSuccessfullyWithStatusCode(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode );
        Assert.assertNotNull(response.getBody());
    }

}
