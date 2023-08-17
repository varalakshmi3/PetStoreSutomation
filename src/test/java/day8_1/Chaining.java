package day8_1;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.github.javafaker.*;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;

public class Chaining {
	//public int id;
	
	@Test
	public void chaingin(ITestContext context)
	{
		Faker face=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", face.name().fullName());
		data.put("job", "SofrwareAPI");
		int	 id=	given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
	
	System.out.println(id);	
	context.setAttribute("USER_ID", id);
	}
	
}
