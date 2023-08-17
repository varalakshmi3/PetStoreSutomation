package day5;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
public class XMLpath_class {
	
	@Test
	void xmlpath_class() {
		Response res=
		given()
		 
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath path=new XmlPath(res.asString());
		
		 List<String> count=path.getList("TravelerinformationResponse.travelers.Travelerinformation");
		 
		 Assert.assertEquals(count.size(), 10);
		 
		
		 
		 List<String>names= path.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		 boolean status = false;
		 for(String trnames:names)
		{
			System.out.println(trnames);
			
			if(trnames.equals("Developer"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	
	}

}
