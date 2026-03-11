package api17.chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GetUser {
	@Test
	void test_GetUser(ITestContext context) {
		//int id=(Integer)context.getAttribute("user_id"); //this will get from create user class
		int id=(Integer)context.getSuite().getAttribute("user_id");
		String bearerToken="16290d8fab47176113c479d05792062dadcd434a60622a65f62b7061a952f428";
		
		       given()
				    .headers("Authorization","Bearer "+bearerToken)
				    .pathParam("id", id)
				    
		       .when()
		            .get("https://gorest.co.in/public/v2/users/{id}")
		            
		       .then()
		            .statusCode(200)
		            .log().all();
		
				     
	}
}
