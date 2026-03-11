package api07.deleteData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Example1 {
	@Test
	public void deleteRecord() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/";
		Response resp=RestAssured.given()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.delete("api/v1/delete/2");
		String statusLine=resp.getStatusLine();
		int statusCode=resp.getStatusCode();
		
		resp.then().statusCode(405);
	}
}
