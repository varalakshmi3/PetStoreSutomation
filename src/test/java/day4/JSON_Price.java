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

public class JSON_Price {
	
	@Test
	void json_validation()
	{
		Response res=given()
				.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		JSONObject obj=new JSONObject(res.asString());
		double totalprice=0.0;
		for(int i=0;i<obj.getJSONArray("book").length();i++)
		{
			String value=obj.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice=totalprice+Double.parseDouble(value);
		}
		
		System.out.println(totalprice);
		
		Assert.assertEquals(totalprice,526.00);
		

}
}