package api14.jsonAndXMLSchemaValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;


public class XMlSchemaValidation {
	@Test
	void jsonSchemaValidation() {
		given()
		.when()
		    .get("http://restapi.adequateshop.com/api/traveler")
		.then()
		    .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("trveler.xsd"));
	}
}
