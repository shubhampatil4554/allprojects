package api09.queryAndParam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class QueryAndPathParam {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void addQueryParam() {
		given()
		   .pathParam("myPath","users")//path parameter
		   .queryParam("page", 2) //query Parameters
		   .queryParam("id", 5) //query parameter
		.when()
		   .get("https://reqres.in/api/{myPath}")
		.then()
		   .statusCode(403)
		   .log()
		   .all();
		   
	}
}
