package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class usingExternalFile {
	
	@Test
	public void fileTest() throws FileNotFoundException
	{
		File f=new File(".\\data.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
						
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("France"))
			.body("phone", equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.log().all();
			
	}

}
