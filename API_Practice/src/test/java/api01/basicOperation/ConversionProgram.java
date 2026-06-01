package api01.basicOperation;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

public class ConversionProgram {
	@Test
	public void workingWithJSONObject() {
		JSONObject ref= new JSONObject();
		ref.put("name", "QA");
		ref.put("email", "abc@gmail.com");
		ref.put("company", "infy");
		
		System.out.println("+++++++++++++++++++++++++s");
		System.out.println("JSONObject entries : "+ref);// {"name":"QA","company":"infy","email":"abc@gmail.com"}
		System.out.println("Get Values : "+ref.values());//[QA, infy, abc@gmail.com]
		System.out.println("Get keys : "+ ref.keySet());//[name, company, email]
		System.out.println("Get value : "+ ref.get("email"));//abc@gmail.com
		System.out.println("+++++++++++++++++++++++++s");
	}
	
	@Test
	public void convertMapToJSONString() {
		Map ref=new HashMap();
		ref.put("name", "QA");
		ref.put("email", "qa@gmail.com");
		ref.put("company", "cogni");
		
		
		String[] courses= {"api testing","database"};
		ref.put("courses", courses);
		
		System.out.println("++++++++++++++++++++++++");
		System.out.println("Map Entries : "+ref);//{courses=[Ljava.lang.String;@2a7f1f10, name=QA, company=cogni, email=qa@gmail.com}
		System.out.println("Get Values : "+ref.values());//[[Ljava.lang.String;@2a7f1f10, QA, cogni, qa@gmail.com]
		System.out.println("Get keys : "+ ref.keySet());//[courses, name, company, email]
		System.out.println("Get value : "+ ref.get("company"));//cogni
		
		//convert Map To JSONString
		String jsonString=JSONValue.toJSONString(ref);
		System.out.println("After converting to json String : "+jsonString);
		//{"courses":[Ljava.lang.String;@2a7f1f10,"name":"QA","company":"cogni","email":"qa@gmail.com"}
		System.out.println("+++++++++++++++++++++++++");
		
	}
	@Test
	public void convertJSONStringToJSONObject() {
		String jsonString="{\"company\":\"cogni\",\"email\":\"qa@gmail.com\",\"name\":\"QA\"}";
		
		//convert JSONString into Object
		Object obj=JSONValue.parse(jsonString);
		
		//convert Object into JSONObject
		JSONObject jsonObject=(JSONObject)obj;
		
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("Print json Object : "+jsonObject);
		System.out.println("Get Values : "+jsonObject.values());
		System.out.println("Get keys : "+ jsonObject.keySet());
		System.out.println("Get value : "+ jsonObject.get("name"));
		System.out.println("+++++++++++++++++++++++++");
		
	}
}
