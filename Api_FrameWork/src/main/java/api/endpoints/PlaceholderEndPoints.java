package api.endpoints;

import api.payload.JsonPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PlaceholderEndPoints {
	public static Response createResource(JsonPayload payload) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(BaseURLs.JSON_CREATE);
		return res;
	}
	public static Response getResource(int id) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id",id)
			    .get(BaseURLs.JSON_GET);
		return res;
	}
	public static Response updateUser(int id,JsonPayload payload) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id", id)
				.body(payload)
				.when()
				.put(BaseURLs.JSON_UPDATE);
		return res;
	}
	public static Response deleteUser(int id) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id", id)
				.when()
				.delete(BaseURLs.JSON_DELETE);
		return res;
	}
}
