package day3;

import org.testng.annotations.Test;

import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
public class Query_path_parameters {
	@Test
	void pathandquery()
	{
		//http://reqres.in/api/users?page=2&id=5
	
	given()
	.pathParam("path", "auther")
	.pathParam("path2", "api")
	.queryParam("page","2")
	.queryParam("id", "5")
	
	.when()
	.get("http://reqres.in/{path2}/{path}")
	
	
	.then()
	.statusCode(200)
	.log().all();
	}
}
