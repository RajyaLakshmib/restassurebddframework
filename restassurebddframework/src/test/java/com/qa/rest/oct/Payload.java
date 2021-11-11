package com.qa.rest.oct;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.qa.main.oct.CompleteJsonParse;

import io.restassured.path.json.JsonPath;

public class Payload extends CompleteJsonParse  {
	
	@Test
	public void retriveData() {
		
		JsonPath js = new JsonPath(payloadmethod());
		
		
		int count = js.getInt("topping.size()");
		System.out.println(count);
		
		int id = js.getInt("id");
		
		System.out.println(id);
		
		String st = js.get("name");
		
		System.out.println(st);
		//List<String>() a = new ArrayList();
		
	//ArrayList<String,String>() temp[][] = ArrayList<String,String>();		
	
		System.out.println(js.get("batters.batter[0].id").toString());
		
		int co = js.getInt("topping.size()");
		
		
		for(int i=0; i<co; i++) {
			System.out.println(js.get("topping["+i+"].id").toString());

			System.out.println(js.get("topping["+i+"].type").toString());
		}
		
		
		
		
		
		
	}

}
