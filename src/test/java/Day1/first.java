package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class first {
	
	int id;
	
	@Test(priority=0)
	void getUser()
	{
		given()
		
		.when()
		
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	@Test(priority=1)
	void createUSer()
	{
		HashMap h = new HashMap();
		h.put("name","Vishal");
		h.put("job","Software Engineer");
		
		id=given()
		.contentType("application/json")
		.body(h)
		
	    .when()
	    .post("https://reqres.in/api/users")
	    .jsonPath().getInt("id");
		/*
		 * .then() 
		 * .statusCode(201) 
		 * .log().all();
		 */
	}
	
	@Test(priority=2,dependsOnMethods= {"createUSer"})
	void updateUser()
	{
		HashMap h1 = new HashMap();
		h1.put("name","Om");
		h1.put("job","Software Developer");
		
		given()
		.contentType("application/json")
		.body(h1)
		
	    .when()
	    .put("https://reqres.in/api/users/"+id)
		
		 .then() 
		 .statusCode(200) 
		 .log().all(); 
	}
	
	@Test(priority=3)
	void deleteUser()
	{
		given()
		.contentType("application/json")
		
	    .when()
	    .delete("https://reqres.in/api/users/"+id)
		
		 .then() 
		 .statusCode(204) 
		 .log().all(); 
	}
	
}
