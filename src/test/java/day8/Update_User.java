package day8;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class Update_User {
	
	void update_user() {
	Faker faker=new Faker();
	JSONObject obj=new JSONObject();
	
	obj.put("name",faker.name().firstName());
	obj.put("gender","female");
	obj.put("email",faker.internet().emailAddress());
	obj.put("status","active");
	
	String token="bc440963bbfe9dc2244b64185faf0c408f3db599c565ee74dddc534f6f575775";
	int id=0;
	
	given()
	.header("Authorization","Bearer "+token)
	.contentType("application/json")
	.body(obj.toString())
	.param("id", id)
	
	.when()
	.post("https://gorest.co.in/public/v2/users/{id}")
	
	.then()
	.statusCode(200)
	.log().all();
	

}
}
