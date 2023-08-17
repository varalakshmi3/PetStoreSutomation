package day3;

import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class Header_info_capture {
	@Test
	void headerinfo()
	{
		 given() 
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Server", "gws")
		.header("Content-Type", "text/html; charset=ISO-8859-1");
		
		
	}
}
