package api04.postData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateFromJsonFile {
	@Test
	public void createUser() {
		byte[] data=null;
		try {
			data=Files.readAllBytes(Paths.get(".\\src\\test\\resources\\testData\\CreateUser.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String  payload=new String(data);
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		//given when 
		Response response = RestAssured.given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post("api/v1/create");
		response.then().statusCode(200);
	}
}
