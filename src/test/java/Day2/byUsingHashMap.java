package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class byUsingHashMap {
	
	int id;
	
	//@Test(priority=1)
	public void postDataHashmap()
	{
		HashMap h = new HashMap();
		h.put("name","Meera");
		h.put("location","Dombivali");
		h.put("phone","9867564518");
		String[] coursearr= {"c++","java"};
		h.put("courses", coursearr);
		
		given()
		.contentType("application/json")
		.body(h)
		
		.when()
		.post("http://localhost:3000/students")

		
		.then()
		.statusCode(201)
		.body("name",equalTo("Meera"))
		.body("location",equalTo("Dombivali"))
		.body("phone",equalTo("9867564518"))
		.body("courses[0]",equalTo("c++"))
		.body("courses[1]",equalTo("java"))
		.log().all();
	}
	@Test(priority=2)
	public void delete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/b685")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
