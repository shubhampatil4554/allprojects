package api01.basicOperation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JsonArray {

	@Test
	public void sampleJsonArray() {
		JSONArray ja= new JSONArray();
		ja.add("Apple");
		ja.add("Orange");
		ja.add("Grapes");
		ja.add("Mango");
		System.out.println("JSONArray Elements are "+ja);
	}
	@Test
	public void sampleJsonArray2() {
		JSONObject ref1=new JSONObject();
		ref1.put("Name", "QA");
		ref1.put("Email", "qa@gmail.com");
		ref1.put("Company", "infy");
		System.out.println("JSONObject Elements of ref1 are "+ref1);
		
		JSONObject ref2=new JSONObject();
		ref2.put("Name", "Tester");
		ref2.put("Email", "tester@gmail.com");
		ref2.put("Company", "IBM");
		System.out.println("JSONObject Elements of ref2 are "+ref2);
		
		
		JSONObject ref3=new JSONObject();
		ref3.put("emp", ref1);
		System.out.println("JSONObject Elements of ref3 are "+ref3);
		
		JSONObject ref4=new JSONObject();
		ref4.put("emp", ref2);
		System.out.println("JSONObject Elements of ref4 are "+ref4);
		
		JSONArray jsa=new JSONArray();
		jsa.add(ref3);
		jsa.add(ref4);
		System.out.println(jsa);
	}
}
