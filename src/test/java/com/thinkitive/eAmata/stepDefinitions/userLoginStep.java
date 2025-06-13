package com.thinkitive.eAmata.stepDefinitions;

import com.thinkitive.eAmata.ApiRequestBuilder;
import com.thinkitive.eAmata.propertyHandler;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class userLoginStep extends ApiRequestBuilder {
    int actualstatusCode;
    static Map<String, Object> loginData;
    static String endPoint;
    static String username = "";

    @BeforeAll
    public static void setUpSuite() {
        endPoint = "login";             //propertyHandler.getEndpoint("login");
        System.out.println("Test Suite Started");
        if(SuperAdminAccessToken == null){

            loginData = new HashMap<>();
            loginData.put("username", propertyHandler.getProperty("SuperAdminEmail"));
            loginData.put("password", propertyHandler.getProperty("password"));
            // System.out.println("logindata: " + loginData);
           
            ApiRequestBuilder.loginPostRequest(null, loginData, endPoint);
            SuperAdminAccessToken = response.jsonPath().get("data.access_token");
            System.out.println("Access token is generated successfully : "+ SuperAdminAccessToken);
        }
        else{
            System.out.println("Access token may or may not be generated for the Super Admin User :" + SuperAdminAccessToken);
        }
    }

    @AfterAll
    public static void tearDownSuite() {
        System.out.println("Test Suite Completed");
    }
    

    @Given("I set up the structure to login User")
    public static String iSetUpTheStructureToLoginUser(Map<String, Object> data) {
        System.out.println("data: " + data.get("endpoint").toString());
        try {
            endPoint = data.get("endpoint").toString();
          username = data.get("username").toString();
            String Password = data.get("password").toString();
            // Credentials taken from the config. properties file
//            loginData = new HashMap<>();
//            loginData.put("username", propertyHandler.getProperty("SuperAdminEmail"));
//            loginData.put("password", propertyHandler.getProperty("password"));

            // Credentials taken from the feature file
            loginData = new HashMap<>();
            loginData.put("username", username);
            loginData.put("password", Password);


        } catch (Exception e) {
            throw new RuntimeException(" Users Credentials not found: " + loginData);
        }
            ApiRequestBuilder.loginPostRequest(null, loginData, endPoint);
        System.out.println("access_Token"+response.jsonPath().get("data.access_token"));
            SuperAdminAccessToken = response.jsonPath().get("data.access_token");

        return SuperAdminAccessToken;
    }


    @Then("I verify that the user is able to login on the super admin portal successfully")
    public void iVerifyThatTheUserIsAbleToLoginOnTheSuperAdminPortalSuccessfully(Map<String, Object> data) {
        response.prettyPrint();
        actualstatusCode = response.getStatusCode();
        if(data.get("scenario").toString().equals("ValidCredentials")){
            System.out.println("User logged in successfully with valid credentials");
            Assert.assertEquals(200, actualstatusCode);
            Assert.assertNotNull(response.jsonPath().get("data.access_token"));
        }
        else if(data.get("scenario").toString().equals("EmailDoesNotExist")){
            System.out.println("Cannot find user with given email "+ username);
            Assert.assertEquals(400, actualstatusCode);
            Assert.assertEquals("Cannot find user with given email superadminqa12@eamata.com", response.jsonPath().get("message"));
        }
        else if(data.get("scenario").toString().equals("invalidEmail")){
            System.out.println("Cannot find user with given email " + username);
            Assert.assertEquals(400, actualstatusCode);
            Assert.assertEquals("Cannot find user with given email superadminqaeamata", response.jsonPath().get("message"));
        }
        else if(data.get("scenario").toString().equals("invalidPassword")){
            System.out.println("Invalid credentials. Please check your username and password and try again or please contact administrator.");
            Assert.assertEquals(400, actualstatusCode);
            Assert.assertEquals("Invalid credentials. Please check your username and password and try again or please contact administrator.", response.jsonPath().get("message"));
        }
        else if (data.get("scenario").toString().equals("BlankCredentials")) {
            System.out.println("Username is mandatory");
            Assert.assertEquals(400, actualstatusCode);
            Assert.assertEquals("Username is mandatory",response.jsonPath().get("message"));
        }
        else {
            System.out.println("Scenario may not be present in the list");
        }

    }


}
