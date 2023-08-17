package day8_1;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Get_All_Users {
	
	@Test(priority = 1)
	public void post_ALL_Users(ITestContext context)
	{
		int id=(Integer)context.getAttribute("USER_ID");
		
				given()
				.contentType("application/json")
				.pathParam("id", id)
		
		.when()
		.get("https://reqres.in/api/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

	

}
