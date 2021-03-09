package com.stepGeneratorClasses;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResposeWithLogs {
	Response response;
	@Given("Send Request to the link with log")
	public void send_Request_to_the_link_with_log() {
	    // Write code here that turns the phrase above into concrete actions
		response=RestAssured.given().when().log().all().get("https://api.ratesapi.io/api/latest?base=USD");
	}

	@When("Response is received with log")
	public void response_is_received_with_log() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Validate the response with log")
	public void validate_the_response_with_log() {
	    // Write code here that turns the phrase above into concrete actions
	}

}
