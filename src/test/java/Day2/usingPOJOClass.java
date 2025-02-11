package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class usingPOJOClass {

	//@Test(priority=1)
	public void postData()
	{
		POJOVariables p = new POJOVariables();
		p.setName("Seet");
		p.setLocation("Kalwa");
		p.setPhone("7845127485");
		String courses[] = {"kol","java"};
		p.setCourse(courses);
		
		given()
		.contentType("application/json")
		.body(p)
		
		.when()
		.post("http://localhost:3000/students")

		
		.then()
		.statusCode(201)
		.body("name",equalTo("Seet"))
		.body("location",equalTo("Kalwa"))
		.body("phone",equalTo("7845127485"))
		.body("courses[0]",equalTo("kol"))
		.body("courses[1]",equalTo("java"))
		.log().all();
	}
	
	 @Test(priority=2)
	public void delete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/97eb")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
