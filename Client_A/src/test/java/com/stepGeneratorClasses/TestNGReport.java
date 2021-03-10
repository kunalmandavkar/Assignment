package com.stepGeneratorClasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestNGReport {
	Response response;
	int resC;
  @Test(dataProvider = "dp")
  public void f(String s) {
		response=RestAssured.get("https://api.ratesapi.io/api/latest?symbols="+s);
		resC=response.getStatusCode();
		Assert.assertEquals(resC,200);
		System.out.println("Response Received");
		Reporter.log("Response received");
	  
  }

  @DataProvider
  public Object[] dp() {
	  Object [] ob=new Object[2];
	  ob[0]="USD";
	  ob[1]="INR";
	  return ob;
  }
}
