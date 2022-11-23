package API_restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class put {

	@Test
	public void test1() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestparam = new JSONObject();
		requestparam.put("id", "7");
		// requestparam.put("", "");
		requestparam.put("id", "0077");
		requestparam.put("name", "sunconure");
		requestparam.put("name", "bird");
		requestparam.put("status", "sold");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparam.toJSONString());
		Response response = httpRequest.request(Method.PUT, "/pet");
		String Body = response.getBody().asString();
		System.out.println("Response Body is:" + Body);

		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Headers head = response.getHeaders();
		for (Header header : head) {
			System.out.println(header.getName() + "  ==  " + header.getValue());
		}
		String headers = response.getContentType();
		Assert.assertEquals(headers, "application/json");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println(" ******************test 2 **********************");
		RestAssured.baseURI= "https://petstore.swagger.io/v2";
		RequestSpecification httpRequest= RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/pet/77");
		String body = response.getBody().asString();
		System.out.println("Response Body is:" + body);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println(" ******************test 3 **********************");
		RestAssured.baseURI= "https://petstore.swagger.io/v2";
		RequestSpecification httpRequest= RestAssured.given();
		Response response = httpRequest.request(Method.DELETE,"/store/order/0077");
		String body = response.getBody().asString();
		System.out.println("Response Body is:" + body);
		Assert.assertEquals(response.getStatusCode(), 404);
		Headers hea = response.getHeaders();
		for(Header header: hea) {
			System.out.println(header.getName() + " "  + header.getValue());
		}
	}
}
