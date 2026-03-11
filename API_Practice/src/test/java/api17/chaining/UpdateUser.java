package api17.chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	void test_UpdateUser(ITestContext context) {
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("email",faker.internet().emailAddress());
		data.put("gender","male");
		data.put("status","active");
		
		String bearerToken="16290d8fab47176113c479d05792062dadcd434a60622a65f62b7061a952f428";
		//int id=(Integer)context.getAttribute("user_id");
		int id=(Integer)context.getSuite().getAttribute("user_id");
	           given()
				    .headers("Authorization","Bearer "+bearerToken)
				    .contentType("application/json")
				    .body(data.toString())
				    .pathParam("id", id)
		       .when()
		            .put("https://gorest.co.in/public/v2/users/{id}")
		       .then()
		            .statusCode(200)
		            .log().all();
		
				     
	}
}
