package com.stepGeneratorClasses;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenarioAssertion {
	Response response;
	int resC=0;
	@Given("Send Request to the given link with negative scenario using assertion")
	public void send_Request_to_the_given_link_with_negative_scenario_using_assertion() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog when sending request\n");
		response=RestAssured.given().when().log().all().get("https://api.ratesapi.io/api/");
	}

	@When("the response is received with negative ssenario using assertion")
	public void the_response_is_received_with_negative_ssenario_using_assertion() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog after receiving response\n");
		RestAssured.get("https://api.ratesapi.io/api/").then().log().all();
		resC=response.getStatusCode();
		System.out.println("Status Code: "+resC);
		
	}

	@Then("Validate the response using Assertion with negative scenario using assertion")
	public void validate_the_response_using_Assertion_with_negative_scenario_using_assertion() {
	    // Write code here that turns the phrase above into concrete actions
		if (resC==200) {
			Assert.assertEquals(resC , 200 , "Response Received");
			System.out.println("Response Received");
		}
		else {
			Assert.assertEquals(resC , 400 , "Negative Response ");
			System.out.println("Negative Response");
		}
//		Assert.assertEquals(resC , 200 , "Response Received");
//		Assert.assertEquals(resC , 400 , "Negative Response ");
	}

}
