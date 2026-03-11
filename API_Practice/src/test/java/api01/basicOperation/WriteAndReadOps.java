package api01.basicOperation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class WriteAndReadOps {
	@Test
	public void writeInJsonFile() {
		Map ref=new HashMap();
		ref.put("name", "QA");
		ref.put("email", "qa@gmail.com");
		ref.put("company", "cogni");
		
		//convert Map To JSONString
		String jsonString=JSONValue.toJSONString(ref);
		System.out.println("After converting to json String : "+jsonString);
		try {
			FileWriter fw=new FileWriter(".\\src\\test\\resources\\testData\\UserDetails.json");
			fw.write(jsonString);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void readFromJsonFile() throws IOException, ParseException {
		//create FileReader Object and pass path in constructor
		FileReader file=new FileReader(".\\src\\test\\resources\\testData\\UserDetails.json");
		//create json parser object
		JSONParser jp=new JSONParser();
		//using jsonparser reference call parse method to convert into object
		Object obj= jp.parse(file);
		//convert object into json object
		JSONObject jobj=(JSONObject)obj;
		System.out.println(jobj.get("name"));
		System.out.println(jobj.get("email"));
		System.out.println(jobj.get("company"));
		
	}
}
