package day3;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;
public class cookie_info_capture {
	@Test
	void cookieinfo()
	{
		 Response res=given()
		
		.when()
		.get("https://www.google.com/");
		 
		 //get single cookie info
		 
		// String Cookie_value=res.getCookie("NID");
		// System.out.println(Cookie_value);
		
		 
		 //get all cookievalue
		 
	Map<String, String>	cookies_value= res.getCookies();
	
	System.out.println(cookies_value.keySet());
	
	for(String key:cookies_value.keySet())
	{
		String value=res.getCookie(key);
		
		System.out.println(key +"\t"+value  );
	}
		 
		 
		
	}

}
