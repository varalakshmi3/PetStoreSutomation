package day2_2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonToken;
import io.restassured.response.ResponseBodyExtractionOptions;

public class Externam<JsonObject> {
	int id;
	@Test(priority = 0)
	public void createdata() throws IOException
	{
		File file=new File(".\\report.json");
		FileReader fr= new FileReader(file);
		JSONTokener tr=new JSONTokener(fr);
	//	JsonObject data=new JsonObject(tr);
	
		id=given()
		.contentType("application/json")
		//.body(data.toString())
		
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
