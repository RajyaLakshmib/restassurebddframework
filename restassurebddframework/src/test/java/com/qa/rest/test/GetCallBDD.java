package com.qa.rest.test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetCallBDD {
	
	@Test
	public void test_numberofcircuitsfor2017_season() {
		
//		given().
//		when().
//		then().
//		assert().
		
		given().
		when().
		  get("http://ergast.com/api/f1/2017/1.json").
	    then().
	      assertThat().
	      statusCode(200).
	      and().
	      body("MRData.RaceTable.Races.Circuit.circuitId",hasSize(1)).
	      and().
	      header("Content-Length",equalTo("621"));
	      
	}

}
