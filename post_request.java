package API_restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_request {

	@Test(priority = 1)
	public void test1() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";

		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("id:", "07");
		requestParams.put("category:", "birds");
		requestParams.put("id:", "007");
		requestParams.put("name", "rossyhead");
		requestParams.put("name", "birds");
		requestParams.put("photoUrls:", "");
		requestParams.put("status: ", "sold");

		httpRequest.header("Content-Type", "application/json");

		// attach above data to the request
		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "pet");

		String Body = response.getBody().asString();
		System.out.println("Response Body is:" + Body);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}
	
	@Test(priority=2)
	public void test2() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.POST, "pet/07");
		String Body = response.getBody().asString();
		System.out.println("Response Body is:" + Body);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

}
