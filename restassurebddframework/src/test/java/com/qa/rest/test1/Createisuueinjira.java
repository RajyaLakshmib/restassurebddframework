package com.qa.rest.test1;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Createisuueinjira {
	
	@Test
	public void jsesstionid() {
		
		JSONObject  jas  = new JSONObject();
		jas.put("username", "rajyalakshmi777@gmail.com");
		jas.put("password", "Raaji@1989");
		
		Response res = RestAssured.given()
		.header("content-type","application/json" )
		.body(jas)
		.post("https://rajya123.atlassian.net/rest/auth/1/session");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().jsonPath().prettify());
//		
//		String sesstion = res.getCookies().get("JSESSIONID");
//		
//		Response re = RestAssured.given().
//		cookie("JSESSIONID", sesstion)
//		.body("")
//		.post();
		
	}

}
