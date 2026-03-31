package api.testcases;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PlaceholderEndPoints;
import api.payload.JsonPayload;
import io.restassured.response.Response;

public class TestJsonPlaceholder {
	JsonPayload getPayload;
	Faker faker;
	@BeforeTest
	public void setUp() {
		faker=new Faker();
		getPayload=new JsonPayload();
		getPayload.setId(faker.idNumber().hashCode());
		getPayload.setTitle(faker.book().title());
		getPayload.setBody(faker.book().publisher());
		
		
	}
	@Test(priority=1)
	public void testCreate() {
		Response res=PlaceholderEndPoints.createResource(getPayload);
		Assert.assertEquals(res.getStatusCode(), 201);
	}
	
	@Test(priority=2)
	public void testGet() {
		Response res=PlaceholderEndPoints.getResource(this.getPayload.getId());//getPayload.getId()
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
