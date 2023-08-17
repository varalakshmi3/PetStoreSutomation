package day7_1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Basic_Auth {
	
	@Test
	void basic()
	{
		given()
		.auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority =1)
	void digest()
	{
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		}
	@Test(priority=3)
	void preemptive()
	{
		given()
		.auth().preemptive().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	
	}
	
	@Test(priority=4)
	void bearesToken()
	{
		
		String str="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";
		
		given()
		.headers("Authorization", "Bearer"+str)
		.when()
		.get("https://api.github.com/users/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=5)
	void oauth2Token()
	{
		
		//String str="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";
		
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/users/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
