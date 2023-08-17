package day5_1;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

public class Fileupload_download {
	
	@Test
	void fileupload()
	{
		File myfile=new File("D:\\jsonfiles\\text4.txt");
	given()
	.multiPart("file",myfile)
	.contentType("multipart/form-data")
	
	.when()
	.post("http://localhost:8080/uploadFile")
	
	.then()
	.statusCode(200)
	.body("fileName",equalTo("text4.txt"))
	.log().all();
	//.body("fileType", equalTo("text/plain"));
	
	

}
}
