package day2;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;


public class PostMethod_HashMap {
	
	
	@Test
	void postmathod()
	{
		HashMap data=new HashMap();
		data.put("name","dundi");
		data.put("location", "hyderabad");
		
		String courArry[]= {"postman","RestAssured"};
		data.put("courses",courArry);
		
	given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/student")
		
				
		.then()
		.statusCode(201)
		.body("name",equalTo("dundi"))
		.body("location",equalTo("hyderabad"))
		.body("courses[0]",equalTo("postman"))
		.body("courses[1]",equalTo("RestAssured"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		

}	@Test
	void deleteRequest()
	{
	given()
	
	.when()
	.put("http://localhost:3000/student/6")
	
	.then()
	.statusCode(200);
	
	}
}