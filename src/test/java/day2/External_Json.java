package day2;


import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonToken;

import java.io.*;

import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.json.JSONTokener;


public class External_Json {
	
	
	@Test(priority=0)
	void jsonLibrary () throws FileNotFoundException
	{
		File file=new File(".\\body.json");
		FileReader fr=new FileReader(file);
		JSONTokener token=new JSONTokener(fr);
		JSONObject data=new JSONObject(token);
		
		
		
	given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/student")
		
				
		.then()
		.statusCode(201)
		.body("name",equalTo("dundi kishore"))
		.body("location",equalTo("bang"))
		.body("courses[0]",equalTo("xml"))
		.body("courses[1]",equalTo("html"))
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

