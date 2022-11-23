package API_restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class datadriven_api {
	@Test(dataProvider = "datas")
	public void test1(String name, String job) {
		System.out.println("************* test 1 *************");
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.PATCH, "api/users/2");
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "name");
		requestparam.put("job", "job");
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@DataProvider(name= "datas")
	String [][] getdata()
	{
		String empdata[][]=
			{
				{"govu", "it"},
				{"bg", "se"}
		};
		return empdata;		
	}
}
