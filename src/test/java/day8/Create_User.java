package day8;

import org.json.JSONObject;
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
import com.github.javafaker.Faker;

public class Create_User {
	@Test
	void createuser()
	{
	
	Faker faker=new Faker();
	JSONObject obj=new JSONObject();
	
	obj.put("name",faker.name().firstName());
	obj.put("gender","male");
	obj.put("email",faker.internet().emailAddress());
	obj.put("status","inactive");
	
	String token="bc440963bbfe9dc2244b64185faf0c408f3db599c565ee74dddc534f6f575775";
	
	int id=given()
	.header("Authorization","Bearer "+token)
	.contentType("application/json")
	.body(obj.toString())
	
	.when()
	.post("https://gorest.co.in/public/v2/users")
	
	.jsonPath().getInt("id");
	
	System.out.println("id is "+id);
	
	}
}
