package day8;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
public class Delete_User {
	
	void delete_user()
	{
		int id=0;
		String token="bc440963bbfe9dc2244b64185faf0c408f3db599c565ee74dddc534f6f575775";
		
		given()
		.header("Authorization","Bearer "+token)
		.pathParam("id", id)
		
		.when()
		.delete("")
		.then()
		.statusCode(200);
		
	}

}
