package api13.fileUpload;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;



public class FileUploadAndDownload {
	@Test
	void singleFileUpload() {
		File myFile=new File("D:\\Acceleration\\Api\\fileUpload.txt");
		given()
		    .multiPart(myFile)
		    .contentType("multiPart/form-data")
		.when()
		    .post("http://localhost:8080/uploadFile")
		.then()
		    .statusCode(200)
		    .body("fileName", equalTo("fileUpload.txt"))
		    .log().all();
	}
	@Test
	void multipleFileUpload() {
		File myFile1=new File("D:\\Acceleration\\Api\\fileUpload1.txt");
		File myFile2=new File("D:\\Acceleration\\Api\\fileUpload2.txt");
		given()
		    .multiPart("files",myFile1)
		    .multiPart("files",myFile2)
		    .contentType("multiPart/form-data")
		    
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		    
		.then()
		    .statusCode(200)
		    
		    .body("[0].fileName", equalTo("fileUpload1.txt"))
		    .body("[1].fileName", equalTo("fileUpload2.txt"))
		    
		    .log().all();
	}
	@Test
	void multipleFileUpload1() {
		File myFile1=new File("D:\\Acceleration\\Api\\fileUpload1.txt");
		File myFile2=new File("D:\\Acceleration\\Api\\fileUpload2.txt");
		
		File[] fileArr= {myFile1,myFile2};
		given()
		    .multiPart("files",fileArr)
		    .contentType("multiPart/form-data")
		    
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		    
		.then()
		    .statusCode(200)
		    
		    .body("[0].fileName", equalTo("fileUpload1.txt"))
		    .body("[1].fileName", equalTo("fileUpload2.txt"))
		    
		    .log().all();
	}
	@Test
	void fileDownload() {
		given()
		.when()
		    .get("http://localhost:8080/downloadFile/fileUpload1.txt")
		.then()
		    .statusCode(200)
		    .log().body();
	}
}
