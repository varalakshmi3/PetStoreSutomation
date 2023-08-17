package day5;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class XMLResponsebody {
	
	@Test()
	void xmlresponse()
	{
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
	}

	
	}


