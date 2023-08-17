package day1_1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;
public class First_day {
	
		@Test(priority = 1)
		public void getdetails()
		{
			given()
			.pathParam("myparam", "users")
			.queryParam("page", "2")
			
			.when()
			.get("https://reqres.in/api/{myparam}")
			
			.then()
			.statusCode(200)
			.log().all();

			
		}
		@Test(priority = 2 ,dependsOnMethods = "getdetails")
		public void putdetails()
		{
			int id;
			
			HashMap<String,String> data=new HashMap<String, String>();
			data.put("name","varalakshmi");
			data.put("job", "IT");
			
			id=given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
			
		}
		@Test(priority = 3,dependsOnMethods = "putdetails")
	public void update()
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "varalakshmi");
		data.put("job", "software");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/id")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
