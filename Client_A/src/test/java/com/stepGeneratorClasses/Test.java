package com.stepGeneratorClasses;
import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test {
	Response response;
	int resC;
	@Given("^Send Request to the link$")
	public void open_Browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		response=RestAssured.get("https://api.ratesapi.io/api/latest?symbols=USD");
	}
	@When("^Response is received$")
	public void email_asked() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		resC=response.getStatusCode();
		System.out.println("Status Code: "+resC);
		response.prettyPrint();
	}	
	@Then("^Validate the response$")
	public void enter_the_Email() throws Throwable {	
		// Write code here that turns the phrase above into concrete actions
		if(resC==200) {
			System.out.println("Positive Response received");
			JsonPath jsonPathEvaluator = response.jsonPath();
			HashMap<String, Integer> name = jsonPathEvaluator.get("rates");
			//Here we are validating when we pass USD as argument the correct response is getting or not
			if(name.containsKey("USD")) {
				System.out.println("Correct response Received");
				System.out.println(name.get("USD"));
			}
			else {
				System.out.println("Wrong Response Received");
			}
		}
		else {
		System.out.println("Some error occur Negative Response received");
		}	
	}
	
	
	

	
	
	
}
