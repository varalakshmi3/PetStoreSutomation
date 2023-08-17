package day2;


import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;


public class Post_jsonMethod {
	
	
	@Test(priority=0)
	void jsonLibrary ()
	{
		JSONObject data=new JSONObject();
		data.put("name","dundi123" );
		data.put("location", "hyderabad");
		
		String courArry[]= {"postman","RestAssured"};
		data.put("courses",courArry);
		
	given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/student")
		
				
		.then()
		.statusCode(201)
		.body("name",equalTo("dundi123"))
		.body("location",equalTo("hyderabad"))
		.body("courses[0]",equalTo("postman"))
		.body("courses[1]",equalTo("RestAssured"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		

}	
	
	@Test(priority=2)
	void deleteRequest()
	{
	given()
	
	.when()
	.delete("http://localhost:3000/student/6 ")
	
	.then()
	.statusCode(200);
	
	}
}
