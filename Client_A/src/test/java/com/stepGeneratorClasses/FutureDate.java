package com.stepGeneratorClasses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class FutureDate {
	Response response;
	int resC=0;
	String da="2022-01-10";
	@Given("Send Request to the given link with negative scenariousing future date")
	public void send_Request_to_the_given_link_with_negative_scenariousing_future_date() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog when sending request\n");
		response=RestAssured.given().when().log().all().get("https://api.ratesapi.io/api/"+da);
	}
	@When("the response is received with negative ssenario using future date")
	public void the_response_is_received_with_negative_ssenario_using_future_date() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\nLog after receiving response\n");
		resC=response.getStatusCode();
		RestAssured.get("https://api.ratesapi.io/api/"+da).then().log().all();
	}
	@Then("Validate the response using Assertion with negative scenario using future date")
	public void validate_the_response_using_Assertion_with_negative_scenario_using_future_date() {
	    // Write code here that turns the phrase above into concrete actions
		if (resC==200) {
			System.out.println("Response Received");
			JsonPath jsonPathEvaluator = response.jsonPath();
			String d = jsonPathEvaluator.get("date");
			System.out.println("Date in the response: "+d);
			System.out.println("Date in the code: "+da);
			if (d.equals(da)) {
				System.out.println("Proper response received");
			}
			else {
				System.out.println("\nOnly provide data from 1999 to todays date");
			}
		}
		else {
			System.out.println("No Response");
		}    
	}
}
