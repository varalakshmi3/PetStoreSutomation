package day4;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;


public class ParsingJSONResponse {
	// @Test
	/*
	 * void jsonResponse()
	{
		given()
		.contentType(Content-Type.JSON)
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("book[3].title",equalTo("The Lord Of The Rings"));
	}*/
	
	@Test
	void json_validation()
	{
		Response res=given()
		
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.contentType(), "application/json; charset=utf-8");
		 
	String value=res.jsonPath().get("book[3].title").toString();
	
	System.out.println(value);
		
	}

}
