package api12.xmlResponseValidation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class testXMLResponse {
	@Test
	void testXmlResponse() {
		/*
		 * //Approach 1
		 * 
		 *  given()
		 *  .when()
		 * .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		 *  .then()
		 * .statusCode(200)
		 *  .header("Content-Type", "application/xml; charset-utf-8")
		 * .body("TravelerInformationResponse.page", equalTo("1"))
		 * .body("TravelerInformationResponse.travelers.Travelerinforation[0].name",
		 * equalTo("Vijay"));
		 * +++++++++++++++++++++++++++++++++++++++++
		 * Approach 2
		 * 
		 * Response res=given()
		 *  .when()
		 * .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		 * 
		 * Assert.assertEquals(res.getStatusCode,200);
		 * Assert.assertEquals(res.getHeader("Content-Type"), "application/xml; charset-utf-8");
		 * 
		 * String pageNo=res.xmlPath().get("TravelerInformationResponse.page").toString();
		 * Assert.assertEquals(pageNo,1);
		 * 
		 * String travelName=res.xmlPath().get("TravelerInformationResponse.travelers.Travelinfo[0].name").toString();
		 * Assert.assertEquals(travelName,"");
		 * 
		 */
	}
	void testXMLResponseBody() {
		/*Response res=given()
				  .when()
				     .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		    XmlPath xmlObj=new XmlPath(res.asString());
		    //Verify Total no of travellers
		    List<String> travellers=xmlObj.getList("TravelerInformationResponse.travelers.Travelinfo");
		    Assert.assertEquals(travellers.size(),10);
		    
		    //Verify Traveller name
		     boolean status=false;
		     for(String trv: travellers) {
		    	 if(trv.equals("vijay")) {
		    		 status=true;
		    		 break;
		    	 }
		     }
		     Assert.assertEquals(status, true);*/
	}
}
