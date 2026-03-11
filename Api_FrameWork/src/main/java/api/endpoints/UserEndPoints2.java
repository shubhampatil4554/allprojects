package api.endpoints;

import api.payload.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ResourceBundle;
public class UserEndPoints2 {
	static ResourceBundle getURL() {
		ResourceBundle routes=ResourceBundle.getBundle("routes");//Load Propeties
		return routes;
	}
	public static Response createUser(UserPayload payload) {
		String post_url=getURL().getString("post_url");
		
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);
		return res;
	}
	public static Response getUser(String username) {
		String get_url=getURL().getString("get_url");
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",username)
			    .get(get_url);
		return res;
	}
	public static Response updateUser(String username,UserPayload payload) {
		String update_url=getURL().getString("update_url");
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(update_url);
		return res;
	}
	public static Response deleteUser(String username) {
		String delete_url=getURL().getString("delete_url");
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.when()
				.delete(delete_url);
		return res;
	}
}
