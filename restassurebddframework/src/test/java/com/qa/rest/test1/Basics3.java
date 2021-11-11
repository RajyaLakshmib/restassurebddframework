package com.qa.rest.test1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics3 {
	
	@Test
	public void getLatestTweet() {
		
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		//given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken);
	}

}
