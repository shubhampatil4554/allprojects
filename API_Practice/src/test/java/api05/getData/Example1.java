package api05.getData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example1 {
	@Test
	public void getData() {
		RestAssured.baseURI=("https://dummy.restapiexample.com/");
		RequestSpecification request=RestAssured.given()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON);
		Response resp=request.when().get("api/v1/employees");
		String statusline=resp.getStatusLine();
		int statuscode=resp.getStatusCode();
		String body=resp.getBody().asString();
		resp.then().statusCode(200);
		System.out.println(resp.getBody().asString());
	}
}
