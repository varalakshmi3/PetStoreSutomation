package day6_1;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;

public class XMLSchemavalidator {
	@Test(priority=1)
	void schemaValidator()
	{
		given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml_schema.xsd"));
	}

}
