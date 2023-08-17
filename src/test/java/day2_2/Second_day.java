package day2_2;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalTo;

public class Second_day {
	public int id;
	@Test(priority=1)
	public void createdata()
	{
		//HashMap data=new HashMap();
		JSONObject data=new JSONObject();
		data.put("name","dundi");
		data.put("location", "Hyderabad");
		data.put("phoneno", "123123");
		String courArry[]= {"postman","RestAssured"};
		data.put("courses",courArry);

		
		id=given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/report")
		.jsonPath().getInt("id");
		
		
	}
	@Test(priority = 2,dependsOnMethods ="createdata" )
	public void delete()
	{
		when()
		.delete("http://localhost:3000/report/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
