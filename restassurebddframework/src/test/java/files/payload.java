package files;

public class payload {
	
	public static String addPlace() {
		
		return "{\r\n" + 
				"    \"location\" : {\r\n" + 
				"        \"lat\": -100.383494,\r\n" + 
				"        \"lng\": 33.427362\r\n" + 
				"    },\r\n" + 
				"    \"accuracy\": 50,\r\n" + 
				"    \"name\": \"Front line house\",\r\n" + 
				"    \"phone_number\": \"(+91)984 038 2690\",\r\n" + 
				"    \"address\": \"sample\",\r\n" + 
				"    \"types\": [\r\n" + 
				"        \"show park\",\r\n" + 
				"        \"shop\"\r\n" + 
				"    ],\r\n" + 
				"    \"website\": \"http://google.com\",\r\n" + 
				"    \"language\": \"French\"\r\n" + 
				"}";
		
	}
	
	public static String updatePlace(String placeId,String updatedString) {
		return "{\r\n" + 
				"    \"place_id\": \""+placeId+"\",\r\n" + 
				"    \"address\": \""+updatedString+"\",\r\n" + 
				"    \"key\": \"qaclick123\"\r\n" + 
				"}";
	}
	
	public static String CoursePrice() {
		return "{\r\n" + 
				"    \"dashboard\": {\r\n" + 
				"        \"purchaseAmount\": 910,\r\n" + 
				"        \"website\": \"rahualshettyacademy.com\"\r\n" + 
				"    },\r\n" + 
				"    \"courses\": [\r\n" + 
				"        {\r\n" + 
				"            \"title\": \"selenium python\",\r\n" + 
				"            \"price\": 50,\r\n" + 
				"            \"copies\":6\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"title\": \"cypress\",\r\n" + 
				"            \"price\": 40,\r\n" + 
				"            \"copies\": 4\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"title\": \"RPA\",\r\n" + 
				"            \"price\": 45,\r\n" + 
				"            \"copies\": 10\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"\r\n" + 
				"}";
		
	}

}
