package day2_2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class Pojo_implementation {

	public int id;
	@Test(priority=1)
	public void createdata()
	{
		Pojo_post data=new Pojo_post();
		data.setLocation("dundi");
		data.setLocation("Bangaloor");
		data.setPhoneno("9392507880");
		String cour[]= {"java","perl"};
		data.setCourses(cour);

		
		id=given()
		.contentType("application/json")
		.body(data)
		
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
