package day3;


import org.testng.annotations.Test;

import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
public class Demo {
	@Test
	void test_cookies() {
		given()
		
		.when()
		.get("https://www.google.com")
		
		.then()
		.statusCode(200)
		.cookies("NID","511%3DZ2XVTJpJDqMrc34n8XTy2HHT8rBOmFdrKU_Zd_NyDjZoTC26gT0nz2TyPuWVzXd75bZZvn-XHpVpzPykhNTasPvLj0Gw9dSHlohYB389NxuaDf2kIJ9H0EwW12hsx13IWAm7Vgj5MxWCbj-wE-bgtnl1HIOwVsIruAw6stCUXVY")
		.log().all();
		
	}

}
