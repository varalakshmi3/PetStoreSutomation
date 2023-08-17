package day6;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Serelization {
	@Test
	void Java_Serealization() throws JacksonException
	{
		Student stupojo=new Student();
		stupojo.setName("ValueLabs");
		stupojo.setLocation("Hyderabad");
		String courAyyar[]= {"C#","Java"};
		stupojo.setCourses(courAyyar);
		ObjectMapper ojj=new ObjectMapper();
		String data=ojj.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(data);
	}
	
	@Test
	void JSON_Java() throws JsonMappingException, JsonProcessingException
	{
		String json="{\r\n"
				+ "  \"name\" : \"ValueLabs\",\r\n"
				+ "  \"location\" : \"Hyderabad\",\r\n"
				+ "  \"courses\" : [ \"C#\", \"Java\" ]\r\n"
				+ "}";
		ObjectMapper obj=new ObjectMapper();
		Student data=obj.readValue(json, Student.class);
		System.out.println("name"+data.getName());
		System.out.println("location"+data.getLocation());
		System.out.println("course1"+data.getCourses()[0]);
		System.out.println("course2"+data.getCourses()[1]);
	}

}
