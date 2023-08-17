package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;


public class NewTestCase { 
	int id;
	
	
	@Test(priority = 1)
	void getUsers()
	{
	when()
	.get("https://reqres.in/api/users?page=2")
	
	.then()
	.statusCode(200)
	.log().all();
	}
	
	@Test(priority = 2)
	void createuser()
	{
		HashMap data=new HashMap<String, String>();
		data.put("name", "pavan");
		data.put("job", "trainer");
		
		
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(201)
	//	.
		//.log().all();
	}
	
	@Test(priority = 3,dependsOnMethods = {"createuser"})
	void update()
	
		{
			HashMap data=new HashMap<String, String>();
			data.put("name", "john");
			data.put("job", "teacher");
			
			
			
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.put("https://reqres.in/api/users/"+id)
			
			
			.then()
			.statusCode(200)
			.log().all();
		
	}
	@Test(priority = 4)
	void deleteuser()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/\"+id")
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
