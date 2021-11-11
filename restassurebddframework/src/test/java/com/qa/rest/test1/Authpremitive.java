package com.qa.rest.test1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authpremitive {
	
	@Test
	public void method1() {
	Response code = RestAssured.
				given()
				.auth()
				.preemptive()
				.basic( "ToolsQA", "TestPassword")
				.when()
				.get("https://restapi.demoqa.com/authentication/CheckForAuthentication");
		
		System.out.println("response code from server:"+code.getStatusCode());
		
	}

}
