package api05.getData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Example2 {
	@Test
	public void retriveData() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		Response resp = RestAssured.given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().get("api/v1/employees");
		String body=resp.getBody().asString();
		int statusCode=resp.getStatusCode();
		String statusLine=resp.getStatusLine();
		
		resp.then().statusCode(200);
		System.out.println(body);
	}
}
