package api04.postData;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUsingJSONObject {
	@Test
	public void createUser() {
		JSONObject obj = new JSONObject();
		obj.put("name", "test");
		obj.put("salary", "123");
		obj.put("age", "23");

		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		//given when 
		Response response = RestAssured.given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(obj)//toString also used
				.when()
				.post("api/v1/create");
		//then
		response.then().statusCode(200);
	
	}
}
