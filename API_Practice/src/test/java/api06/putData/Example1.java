package api06.putData;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Example1 {
	@Test
	public void updateData() {
		JSONObject payload = new JSONObject();
		payload.put("name", "test");
		payload.put("salary", 123);
		payload.put("age", 23);
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		RequestSpecification request = RestAssured.given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toJSONString());
		Response resp=request.when().put("api/v1/update/21");
		String body=resp.getBody().asString();
		int statusCode=resp.getStatusCode();
		String statusLine=resp.getStatusLine();
		resp.then().statusCode(200)
		.body("name", equalTo("test"))
		.body("salary", equalTo(123))
		.body("age", equalTo(23));

	}
}
