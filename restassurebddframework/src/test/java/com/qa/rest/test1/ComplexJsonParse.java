package com.qa.rest.test1;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	@Test
	public void jsonpar() {
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		System.out.println(js);
		
		//print no of courses in API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//print purchage amount
		int totalamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		
		//print title of the first course
		String titleCourse = js.getString("courses[0].title");
				System.out.println(titleCourse);
				
		//print all courses title and price
		for(int i=0; i<count; i++) {
			System.out.println(js.getString("courses["+i+"].title")+" "+js.getInt("courses["+i+"].price"));
		}
		
		
		//print no of copies sold by RPA
		
		for(int j=0; j<count; j++) {
			if(js.getString("courses["+j+"].title").equalsIgnoreCase("RPA")) {				
				System.out.println(js.getInt("courses["+j+"].copies"));
				break;
			}
		}
		
		//print sum of courses price
		
		int temp = 0;
		for(int k=0; k<count; k++) {
			temp = temp+js.getInt("courses["+k+"].price")*js.getInt("courses["+k+"].copies");
		}
		System.out.println(temp);
		
		
		
		
		
		
		
		
	}
	


}
