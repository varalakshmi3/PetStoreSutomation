package day4;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.response.Response;

public class Json_Validation {
	
	@Test
	void json_validation()
	{
		Response res=given()
				.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		//JSONObject class
		JSONObject obj=new JSONObject(res.asString());
		
	/*	for(int i=0;i<obj.getJSONArray("book").length();i++)
		{
			
			String book_Name=obj.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(book_Name);
		}*/
		//String response=res.toString()
		boolean status=false;
		for(int i=0;i<obj.getJSONArray("book").length();i++)
		{
			
			String book_Name=obj.getJSONArray("book").getJSONObject(i).get("title").toString();

			
			if(book_Name.equals("11111"))
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
		
		
	}

}
