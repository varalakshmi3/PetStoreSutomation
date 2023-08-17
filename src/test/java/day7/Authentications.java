package day7;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
public class Authentications {

	@Test(priority=1) 
	void Authentication_Basic()
	{
		given()

		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority=2)
	void Authentication_Digest()
	{
		given()

		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority=3)
	void Authentication_Preemptive()
	{
		given()

		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority = 4)
	void Authentication_Bearer() {
		String token="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";
		
		given()
		.header("Authorization","Bearer "+token)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
