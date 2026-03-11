package api04.postData;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUsingString {
	@Test
	public void createUser1() {
		String payload="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		RestAssured.baseURI="https://dummy.restapiexample.com/";
		//Given
		RequestSpecification request=RestAssured.given()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload);
		//When
		Response response=request.when().post("api/v1/create");
		
		int statuscode=response.getStatusCode();
		String statusLine=response.getStatusLine();
		String body=response.getBody().asString();
		
		//Then
		response.then().statusCode(200);
		//or
		Assert.assertEquals(statuscode,200);
	}
}
