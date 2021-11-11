package com.qa.rest.test1;

import org.testng.annotations.Test;

import com.qa.resrassureBDD.Addplace;
import com.qa.resrassureBDD.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Addserializa {
	
	
	@Test
	public void addjson() {
		
		Addplace p = new Addplace();
		p.setAccuracy(50);
		p.setAddress("29,side layout");
		p.setLanguage("French-in");
		p.setPhone_number("99999999999");
		p.setWebsite("https://rahualshettyacademy.com");
		p.setName("Raj");
		
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		
		Location l= new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("Key","qaclick123").
		setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		//RestAssured.baseURI = "https://rahulshettyacademy.com/";
		Response res = given().spec(req)
		.body(p)
		.when().post("maps/api/place/add/json")
		.then().spec(resp).extract().response();
		
		String responsestring  = res.asString();
		System.out.println(responsestring);

		
	}

}
