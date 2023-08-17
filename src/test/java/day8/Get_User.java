package day8;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
public class Get_User {
	@Test
	void get_user()
	{
		int id=0;
		String token="bc440963bbfe9dc2244b64185faf0c408f3db599c565ee74dddc534f6f575775";
		
		given()
		.header("Aurhorization","Bearer "+token)
		.pathParam("id",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200);
	}

}
