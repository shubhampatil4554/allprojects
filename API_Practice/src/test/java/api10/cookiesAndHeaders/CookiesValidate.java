package api10.cookiesAndHeaders;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesValidate {
	@Test(priority=1)
	void testCookies() {
		given()
		.when()
		 .get("https://www.google.com/")
		.then()
		 .cookie("AEC","AaJma5sNcYRzR37P2WCrCuXPnCPs8wSN4KIHvxLtVj8rbhew2YC7DJpAmw")
		 .log().all();
	}
	@Test(priority=2)
	void testCookies2() {
	   Response res=	given()
		.when()
		 .get("https://www.google.com/");
	   
		//get single cookie info
	  String cookieValue= res.getCookie("AEC");
	  System.out.println("value of AEC cookie"+cookieValue);
	  
	  //get All cookies info
	  Map<String,String> cookiesValues=res.getCookies();
	 // System.out.println(cookiesValue.keySet());
	    for(String cv : cookiesValues.keySet()) {
	    	String cookie=res.getCookie(cv);
	    	 System.out.println(cv +" = "+cookie);
	    }
	    
	}
}
