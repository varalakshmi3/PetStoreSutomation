package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class Different_logs {
	@Test
	void logs()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.log().headers();
		//.log().cookies();
		//.log().body();
		//.log().all();
		
	}

}
