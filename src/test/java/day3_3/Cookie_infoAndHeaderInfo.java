package day3_3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.*;

public class Cookie_infoAndHeaderInfo {
	
	@Test
	public void cookie()
	{
	Response res=given()
		
		.when()
		.get("https://www.google.com");
	
	//String str=res.getCookie("NID");
	//System.out.println(str);
	
	Map<String,String> cookies=res.getCookies();
	for(String k:cookies.keySet())
	{
		String cookie_value=res.getCookie(k);
		System.out.println(k+ "     "+cookie_value);
	}
	
	Headers her=res.getHeaders();
	for(Header h:her)
	{
		System.out.println(her+"    "+h.getValue());
	}
		
		
	}

}
