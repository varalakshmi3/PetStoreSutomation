package day4_4;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.json.JSONObject;

public class Response_Body {
	@Test(priority = 1)
	public void data()
	{
		Response res=given()
				.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String name=res.jsonPath().get("book[0].title").toString();
		Assert.assertEquals(name, "Sayings of the century");
		
		JSONObject ob=new JSONObject(res.asString());
		
		float total=0;
		boolean status=false;
		for(int i=0;i<ob.getJSONArray("book").length();i++)
		{
		String	title=ob.getJSONArray("book").getJSONObject(i).get("title").toString();
		String tot=ob.getJSONArray("book").getJSONObject(i).get("price").toString();
		if(title.equals("Sword of Honour"))
				{
			status=true;
				}
		total=total+Float.parseFloat(tot);
		System.out.println(title);
		}
		
		Assert.assertEquals(status, true);
		System.out.println("Total Price is" +total);
		
	}

}
