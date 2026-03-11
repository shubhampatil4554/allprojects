package api17.chaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	@Test
	void test_CreateUser(ITestContext context) {
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("email",faker.internet().emailAddress());
		data.put("gender","male");
		data.put("status","inactive");
		
		String bearerToken="16290d8fab47176113c479d05792062dadcd434a60622a65f62b7061a952f428";
		
		int id=given()
				    .headers("Authorization","Bearer "+bearerToken)
				    .contentType("application/json")
				    .body(data.toString())
		       .when()
		            .post("https://gorest.co.in/public/v2/users")
		            .jsonPath().getInt("id");
		System.out.println("Generated id is "+id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
				     
	}
}
