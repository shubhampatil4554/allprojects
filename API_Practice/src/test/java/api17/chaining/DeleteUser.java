package api17.chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	@Test
	void test_DeleteUser(ITestContext context) {
		//int id=(Integer)context.getAttribute("user_id"); //this will get from create user class
		int id=(Integer)context.getSuite().getAttribute("user_id");
		String bearerToken="16290d8fab47176113c479d05792062dadcd434a60622a65f62b7061a952f428";
		
		       given()
				    .headers("Authorization","Bearer "+bearerToken)
				    .pathParam("id", id)
				    
		       .when()
		            .delete("https://gorest.co.in/public/v2/users/{id}")
		            
		       .then()
		            .statusCode(204)
		            .log().all();
		
				     
	}
}
