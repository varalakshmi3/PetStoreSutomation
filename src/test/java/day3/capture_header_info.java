package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class capture_header_info {
	@Test
	void headerinfo()
	{
		 Response res=  given() 
		
		.when()
		.get("https://www.google.com/");
		 
		// String value=res.getHeader("Content-Type");
		// System.out.println("the value of content_ type is"+value);
		 
		Headers myheader= res.getHeaders();
		
		for(Header hd:myheader)
		{
			System.out.println(hd+"\t"+hd.getValue());
		}
		
		
		
	}
}

