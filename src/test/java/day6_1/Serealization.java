package day6_1;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class Serealization {
	@Test
	void serealization() throws IOException
	{
		Student_POJO stu=new Student_POJO();
		stu.setName("VARALAKSHMI");
		stu.setLocation("VIJAYAWADA");
		String courarray[]= {"c++","PERL"};
		stu.setCourses(courarray);
		
		given()
		.contentType("application/json")
		.body(stu)
		
		.when()
		.post("http://localhost:3000/student");
		
		ObjectMapper obj=new ObjectMapper();
		String jsondata=obj.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		System.out.println(jsondata);
		
		System.out.println(jsondata);
	}

}
