package api11.jsonResponseValidate;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
	// Approach 1
	@Test(priority = 1)
	void testJsonResponseData() {
		given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8").body("[1].title", equalTo("qui est esse"));
	}

	// Approach 2
	@Test(priority = 2)
	void testJsonResponseData1() {
		Response res = given().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");

		String title = res.jsonPath().get("[1].title").toString();
		Assert.assertEquals(title, "qui est esse");
	}

	/*
	 * @Test(priority = 3) void testJsonResponseData3() { 
	 * Response res =given().contentType(ContentType.JSON)
	 *              .when()
	 *                      .get("https://dummy.restapiexample.com/api/v1/employees"); 
	 * JSONObject jo =new JSONObject(res.toString());
	 *  for (int i = 0; i <jo.getJSONArray("$.data[*].employee_name").length(); i++) 
	 *  { 
	 *    String ename =jo.getJSONArray("$.data[*].employee_name").getJSONObject(i).get("cemployee_name").toString(); 
	 *     System.out.println(ename); 
	 * } }
	 * 
	 *OR
	 *boolean status=false;
	 *for(int i = 0; i <jo.getJSONArray("$.data[*].employee_name").length(); i++){
	 *String ename =jo.getJSONArray("$.data[*].employee_name").getJSONObject(i).get("cemployee_name").toString();
	 *if(ename.equals(""){
	 *status=true;
	 *break;
	 *}
	 *Assert.assertEquals(status,true);
	 *}
	 */
}
