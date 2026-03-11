package api15.serializationAndDeserializationWithPojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api03.pojoClass.Example2;

public class SerializationDeserialization {
	@Test
	void convertPojoToJson() throws JsonProcessingException {
		Example2 objPojo=new Example2();
		objPojo.setEmpID(200);
		objPojo.setName("QA");
		objPojo.setSalary(30000.20);
		
		//convert java object to json object(Serialization)
		ObjectMapper objMapper=new ObjectMapper();
		
		String jsonData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objPojo);
		
		System.out.println(jsonData);
		
	}
	@Test
	void convertJsonToPojo() throws JsonMappingException, JsonProcessingException {
		String jsonData="{\r\n"
				+ "  \"name\" : \"QA\",\r\n"
				+ "  \"empID\" : 200,\r\n"
				+ "  \"salary\" : 30000.2\r\n"
				+ "}";
		//Convert jsonData to pojo object(Deserialization)
		ObjectMapper objMapper=new ObjectMapper();
		Example2 empPojo=objMapper.readValue(jsonData, Example2.class);
		System.out.println("name : "+empPojo.getName());
		System.out.println("empID : "+empPojo.getEmpID());
		System.out.println("salary : "+empPojo.getSalary());
	}
}
