package day5;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.testng.annotations.Test;

public class XML_validations__assterts {
	@Test
	void xml_validation()
	{
		Response res=
		given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.contentType(), "application/xml; charset=utf-8");
		
		String str=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(str, "1");
		
		String str1=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(str1, "Developer");
	}

}
