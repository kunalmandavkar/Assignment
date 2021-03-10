package com.stepGeneratorClasses;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenario {
	Response response;
	int resC=0;
	@Given("Send Request to the given link with negative scenario")
	public void send_Request_to_the_given_link_with_negative_senario() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog when sending request\n");
		response=RestAssured.given().when().log().all().get("https://api.ratesapi.io/pi/latest?base=USD");
	}

	@When("the response is received with negative scenario")
	public void the_response_is_received_with_negative_senario() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog after receiving response\n");
		RestAssured.get("https://api.ratesapi.io/pi/latest?base=USD").then().log().all();
	   
	}

	@Then("Validate the response using Assertion with negative scenario")
	public void validate_the_response_using_Assertion_with_negative_senario() {
	    // Write code here that turns the phrase above into concrete actions
		if(resC==200) {
			System.out.println("Positive Response received");
		}
		else {
		System.out.println("Some error occur Negative Response received");
		}
	}

}
