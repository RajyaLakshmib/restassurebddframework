package com.qa.rest.test1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payload;

public class Basics {
	
	Properties prop ;
	
	@BeforeTest
	public void getData() throws IOException {
		prop = new Properties();
		FileInputStream fis  = new FileInputStream("C:\\Users\\Rajya Lakshmi\\eclipse-workspace\\restassurebddframework\\src\\test\\java\\files\\env.properties");
		prop.load(fis);
		System.out.println( prop.getProperty("HOST"));		
	}
	
     @Test
	public void test() throws IOException {
		// TODO Auto-generated method stub
		
		//given()  input details
		//when() submit API- resource,http method
		//then() Validate API
		
		RestAssured.baseURI = prop.getProperty("HOST");
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.addPlace()).
		//.body(GenerateStringFromResource("C:\\Users\\Rajya Lakshmi\\eclipse-workspace\\restassurebddframework\\src\\test\\java\\files\\sample.json")).
		when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).and()
		.body("scope", equalTo("APP")).and()
		.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).and()
		.extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);//parsing Json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		
		
		//"place_id": "c6e5b3fd98f31913efb4a6fcb01ebb8d",
		//"place_id": "fe05fbdf73777e91c63e57c2f32513cd
		//Add place-> update place with new address  -> get place to validate if new address is present in response
		
		//update
		String UpAddressString = "kaaa1111a";
		
		String updateresponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
				body(payload.updatePlace(placeId,UpAddressString)).
		when().put("maps/api/place/update/json").
		then().assertThat().statusCode(200).and().body("msg", equalTo("Address successfully updated")).and().
		extract().response().asString();
		
		//get
		
		String getresponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).
				when().get("maps/api/place/get/json").
				then().assertThat().statusCode(200).and().body("address", equalTo(UpAddressString)).extract().response().asString();
		
		System.out.println(getresponse);
		JsonPath js1 = new JsonPath(getresponse);//parse Json
		String getaddressresult = js1.getString("address");
		System.out.println(getaddressresult);
		Assert.assertEquals( getaddressresult,UpAddressString);
		
		
				

	}
     
     
     public static String GenerateStringFromResource(String path) throws IOException {
    	 System.out.println("begin");
    	 
    	 return new String(Files.readAllBytes(Paths.get(path)));
    	 
     }

}
