package day5_1;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class XML {
	@Test(priority = 1)
	public void test() {
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler\r\n")

		.then()
		.statusCode(200)
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
	}
	@Test(priority = 2)
	void test2()
	{
		
	Response	 res=
				given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler\\r\\n");
	String contentType=res.getContentType();
	System.out.println(contentType);
	String name=res.htmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
	Assert.assertEquals(contentType,"text/html");
	System.out.println(name);
	//Assert.assertEquals(name, "Developer");
	
		System.out.println(res.htmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name"));
		
	}
	@Test(priority = 3)
	void test3()
	{
		Response	 res=
	given()
	
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler\\r\\n");
		XmlPath path=new XmlPath(res.asString());
		
		String size=path.getList("TravelerinformationResponse.travelers.Travelerinformation").toString();
		int size1=Integer.parseInt(size);
		Assert.assertEquals(size1, 100);
	}

}


