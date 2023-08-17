package day5_1;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import java.io.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
public class Multifile_upload {
	
	@Test(priority = 1)
	void multi_file() {
		
		File file1=new File("D:\\jsonfiles\\text4.txt");
		File file2=new File("D:\\jsonfiles\\text5.txt");
		given()
		.multiPart("files",file1)
		.multiPart("files",file2)
		.contentType("multipart/form-daata")
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("text4.txt"))
		.body("[1].fileName", equalTo("text5.txt"))
		.log().all();
		
	}
	
	@Test(priority = 2)
	void download() {
		given()
		
		.when()
	//	.get("http://localhost:8080/downloadFile/text4.txt")
		.get("http://localhost:8080/downloadFile/text5.txt")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
