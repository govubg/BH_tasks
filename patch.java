package API_restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class patch {
	@Test
	public void test1() {
		System.out.println("************* test 1 *************");
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.PATCH, "api/users/2");
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "govu");
		requestparam.put("job", "IT");
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 2)
	public void test2() {
		System.out.println("************* test 2 *************");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httprequest= RestAssured.given();
		Response response= httprequest.request(Method.PUT,"api/users/2");
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "govu");
		requestparam.put("job", "IT");
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("********** get *************");
		Response resp= httprequest.request(Method.GET,"api/users/2");
		System.out.println(resp.getBody().asString());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void test3() {
		System.out.println("************* test 3 *************");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httprequest= RestAssured.given();
		Response response= httprequest.request(Method.DELETE,"api/users/2");
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println("******* successfully deleted *********");
	}
}
