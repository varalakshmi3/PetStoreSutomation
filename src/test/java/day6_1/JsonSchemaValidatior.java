package day6_1;

import org.testng.annotations.Test;

import day6.JSON_Schema_Validator;
import io.restassured.*;
import io.restassured.matcher.*;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidatior {
	@Test(priority=1)
	void validator()
	{
		given()
		
		.when()
		.get("http://localhost:3000/store")
		.then()
		//.assertThat().body(JsonSchemaValidatior.matchesJsonSchemaInClasspath("store_json_schema.json"));
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("store_json_schema.json"));
		}

}
