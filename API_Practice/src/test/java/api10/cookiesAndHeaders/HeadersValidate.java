package api10.cookiesAndHeaders;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeadersValidate {
	@Test
	void testHeaders() {
		given()
		.when()
		    .get("https://www.google.com/")
		.then()
		    .header("Content-Type", "text/html; charset=ISO-8859-1")
		    .and()
		    .header("Content-Encoding", "gzip")
		    .and()
		    .header("Server", "gws")
		    .log().all();
	}
	@Test
	void testHeaders1() {
		given()
		.when()
		    .get("https://www.google.com/")
		.then()
		    .header("Content-Type", "text/html; charset=ISO-8859-1")
		    .and()
		    .header("Content-Encoding", "gzip")
		    .and()
		    .header("Server", "gws");
	}
	@Test
	void testHeaders2() {
		Response res=given()
		.when()
		    .get("https://www.google.com/");
		
		//get Single Header info
		String headerValue=res.getHeader("Content-Type");
		System.out.println("Header value is "+headerValue);
		
		//get all header info
		Headers headerValues=res.getHeaders();
		for(Header hd: headerValues) {
			System.out.println(hd.getName()+" = "+hd.getValue());
		}
	}
}
