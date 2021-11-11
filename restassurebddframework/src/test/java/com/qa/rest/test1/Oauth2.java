package com.qa.rest.test1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Oauth2 {
	
	@Test
	public void method1() {
		
		Response res = RestAssured.
				given()
				.formParam("client_id", "sample")
				.formParam("client_secret", "e080cd68f6e1cf0dd56de18b0bb9a35c")
				.formParam("grant_type", "client_credentials")
				.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(res.jsonPath().prettify());
		System.out.println(res.jsonPath().get("access_token"));
		
		String accessToken = res.jsonPath().getString("access_token");
		Response resp = (Response) RestAssured.
				given()
				.auth()
				.oauth2(accessToken)
				.when()
				.post("	http://coop.apps.symfonycasts.com/api/1404/chickens-feed")
				.then().assertThat().statusCode(200).extract();
		
		System.out.println(resp.jsonPath().prettify());
				
		
		
				
	}

}
