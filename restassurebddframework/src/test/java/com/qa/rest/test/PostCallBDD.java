package com.qa.rest.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostCallBDD {
	
	@Test
	public void postapi() {
Map<String,Object> map = new HashMap<String,Object>();
map.put("name","morphus");
map.put("job", "software");
JSONObject request = new JSONObject(map);


given().
body(request.toString()).
when().
post("https://reqres.in/api/users").
then().
statusCode(201);


	}
}
