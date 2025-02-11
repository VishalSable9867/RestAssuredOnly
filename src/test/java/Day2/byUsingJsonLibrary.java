package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class byUsingJsonLibrary {
	//@Test(priority=1)
		public void postJsonObject()
		{
			JSONObject h = new JSONObject();
			h.put("name","Meera");
			h.put("location","Dombivali");
			h.put("phone","9867564518");
			String[] coursearr= {"c++","java"};
			h.put("courses", coursearr);
			
			given()
			.contentType("application/json")
			.body(h.toString())   //toString method is mandatory while using JSONObject library if not use then it will throw error
			
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
			.delete("http://localhost:3000/students/0376")
			
			.then()
			.statusCode(200)
			.log().all();
		}

}
