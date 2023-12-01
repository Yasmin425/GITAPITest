package com.git.models.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.git.models.requests.GetSingleRepoPOJO;
import com.git.models.response.CreateNewRepoPOJO;
import com.git.models.response.UpdateRepoPOJO;


import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GitAPIscripts {

private static String mytoken="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";
	
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void GetSingleRepoWithPOJO () {
		
		String Expected = "Yasmin425/SalesForceCucumber";
		String Expected2 = "main";
		Header header=new Header("token",mytoken);
		Response res=RestAssured
		.given()
		.header(header)
		.when()
		.get("/repos/Yasmin425/SalesForceCucumber");
		res.prettyPrint();
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
		GetSingleRepoPOJO data= new GetSingleRepoPOJO();
		String Actual= data.getFullName();
		String Actual2= data.getDefaultBranch();
		JsonPath jsonObj = res.body().jsonPath();
		Assert.assertEquals(jsonObj.get("full_name"),"Yasmin425/SalesForceCucumber");
		Assert.assertEquals(jsonObj.get("default_branch"),"master");
	    res.prettyPrint();
		
	}
	
	@Test
	public void GetnonexistingRepoWithPOJO() {
		
		
		Header header=new Header("token",mytoken);
		Response res=RestAssured
		.given()
		.header(header)
		.when()
		.get("/repos/Yasmin425/SalesForceCucumber-noneexistance");
		res.prettyPrint();
		
		res
		.then()
		.statusCode(404)
		.contentType(ContentType.JSON);

		JsonPath jsonObj = res.body().jsonPath();
		Assert.assertEquals(jsonObj.get("message"),"Not Found");

	    res.prettyPrint();
		
	}
	
	@Test
	public void GetAllRepoWithPOJO() {
		
		
		Header header=new Header("token",mytoken);
		Response res=RestAssured
		.given()
		.header(header)
		.when()
		.get("/user/repos");
		res.prettyPrint();
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
		res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetAllReposSchema.json"));
		
	    res.prettyPrint();
		System.out.println("total number of repos="+res.body().jsonPath().get("size()"));
		
	}
	
    @Test
	
	public void CreateRepowithPOJO() {
		Header header = new Header("token",mytoken);
		CreateNewRepoPOJO data= new CreateNewRepoPOJO();
		data.setName("Hello-World");
		data.setDescription("This is your first repo!");
		//data.setHomepage("https://api.github.com");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("/user/repos");	
		
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON);
		
		JsonPath jsonObj = res.body().jsonPath();
		Assert.assertEquals(jsonObj.get("name"),"Hello-World");
		Assert.assertEquals(jsonObj.get("owner.login"),"Yasmin425");
		Assert.assertEquals(jsonObj.get("owner.type"),"user");

		
	}
    
@Test
	
	public void CreateRepowithExistingNameWithPOJO() {
		Header header = new Header("token",mytoken);
		CreateNewRepoPOJO data= new CreateNewRepoPOJO();
		data.setName("Hello-World");
		data.setDescription("This is your first repo!");
		//data.setHomepage("https://api.github.com");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("/repos/Yasmin425/Hello-World");	
		
		res
		.then()
		.statusCode(422)
		.contentType(ContentType.JSON);

		
	}

@Test

public void UpdateRecords() {
Header header = new Header("token",mytoken);
UpdateRepoPOJO data= new UpdateRepoPOJO();
data.setName("name");
data.setDescription("my repository created using apis after update");
data.setPrivate("False");

Response res=RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.patch("/repos/Yasmin425/sep2023a");	

res
.then()
.statusCode(200)
.contentType(ContentType.JSON);

}

@Test

public void DeleteRepowithPOJO() {
Header header = new Header("token",mytoken);
UpdateRepoPOJO data= new UpdateRepoPOJO();


Response res=RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.delete("/repos/Yasmin425/sep2023f");	

res
.then()
.statusCode(204)
.contentType(ContentType.JSON);

System.out.println(res.body());
}

@Test

public void DeleteNonExistanceRepowithPOJO() {
Header header = new Header("token",mytoken);
UpdateRepoPOJO data= new UpdateRepoPOJO();


Response res=RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.delete("/repos/Yasmin425/sep2023f");	

res
.then()
.statusCode(404)
.contentType(ContentType.JSON);


}


	
	
}
