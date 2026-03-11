package api08.intro;

import org.testng.annotations.Test;
//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
	@Test(priority=1)
	void listGetData() {
		given()
		
		.when()
		    .get("https://jsonplaceholder.typicode.com/posts")
		    
		.then()
		    .statusCode(200)
		    .log().all();
	}
	int id;
	
	@Test(priority=2)
	void postData() {
		HashMap data=new HashMap();
		data.put("title", "QA");
		data.put("body", "Tester");
		id=given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .post("https://jsonplaceholder.typicode.com/posts")
		   .jsonPath()
		   .getInt("id");
		//.then().statusCode(201).log().all();
	}
	
	@Test(priority=3,dependsOnMethods={"postData"})
	void updateData() {
		HashMap data=new HashMap();
		data.put("title", "QA");
		data.put("body", "Api Testing");
		given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .put("https://jsonplaceholder.typicode.com/posts/1")
		  
		.then()
		   .statusCode(200)
		   .log().all();
	}
	@Test(priority=4)
	void deleteData() {
		given()
		
		.when()
		   .delete("https://jsonplaceholder.typicode.com/posts/1")
		.then();
	}
}
