package com.stepGeneratorClasses;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseWithAssertion {
	Response response;
	int resC=0;
	@Given("Send Request to the given link")
	public void send_Request_to_the_given_link() {
	    // Write code here that turns the phrase above into concrete actions
		response=RestAssured.get("https://api.ratesapi.io/pi/latest?symbols=USD");
	}

	@When("the response is received")
	public void the_response_is_received() {
	    // Write code here that turns the phrase above into concrete actions
		resC=response.getStatusCode();
		System.out.println("Status Code: "+resC);
		response.prettyPrint();
	}

	@Then("Validate the response using Assertion")
	public void validate_the_response_using_Assertion() {
	    // Write code here that turns the phrase above into concrete actions
		if (resC==200) {
			Assert.assertEquals(resC , 200 , "Response Received");
			System.out.println("Response Received");
		}
		else {
			Assert.assertEquals(resC , 404 , "No Response ");
			System.out.println("No Response");
		}
//		Assert.assertEquals(resC , 200 , "Response Received");
//		Assert.assertEquals(resC , 404 , "No Response ");
	}

}
