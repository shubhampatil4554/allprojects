package api16.authentications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentications {
	@Test(priority=1)
	void testBasicAuthentication() {
		given()
		   .auth().basic("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true))
		   .log().all();
	}
	@Test(priority=2)
	void testDigestAuthentication() {
		given()
		   .auth().digest("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true))
		   .log().all();
	}
	@Test(priority=3)
	void testPreemptiveAuthentication() {
		given()
		   .auth().preemptive().basic("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true))
		   .log().all();
	}
	@Test(priority=4)
	void testBearerTokenAuthentication() {
		String bearerToken="ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP";
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		.when()
		   .get("https://api.github.com/user/repos")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	@Test(priority=5)
	void testOauth1Authentication() {
		given()
		     .auth().oauth("consumerkey", "consumerSecrate", "accessToken", "tokenSecrate")
		.when()
		     .get("url")
		.then()
		     .statusCode(200)
		     .log().all();;
	}
	@Test(priority=6)
	void testOauth2Authentication() {
		given()
		     .auth().oauth2("ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP")
		.when()
		     .get("https://api.github.com/user/repos")
		.then()
		     .statusCode(200)
		     .log().all();;
	}
	@Test(priority=7)
	void testApiKeyAuthentication() {
	  /*given()
		     .queryParam("appid", "fe9c5cddb7e01d747b4611cefc9eaf2c")//appid is Apikey
		.when()
		     .get("http://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
		     .statusCode(200)
		     .log().all();   */
		//or
	given()
	     .queryParam("appid", "fe9c5cddb7e01d747b4611cefc9eaf2c")//appid is Apikey
	     .pathParam("myPath", "data/2.5/forecast/daily")
	     .queryParam("q", "Delhi")
	     .and()
	     .queryParam("units", "metric")
	     .and()
	     .queryParam("cnt", "7")
	.when()
	     .get("http://api.openweathermap.org/{myPath}")
	.then()
	     .statusCode(200)
	     .log().all();
	}
	
}
