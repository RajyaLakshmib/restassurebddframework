package com.qa.rest.a9112021;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class GetAPi {
	@Test
	public void test123() {
		
		RestAssured.baseURI = "http://ergast.com";
		
		String response = given().log().all().
		when().get("api/f1/2017/1.json").
		then().log().all().assertThat().statusCode(200).body("MRData.total",equalTo("1")).
		header("Content-Length", equalTo("621")).extract().response().asString();
		
		
	
		
		JsonPath res = new JsonPath(response);
		System.out.println(res.getString("MRData.total"));
		
	}
	

}
