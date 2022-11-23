package API_restassured;

import org.openqa.selenium.devtools.v104.cachestorage.model.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_request {

	// link
	// https://www.pavantestingtools.com/2019/05/apiwebservices-testing-using-restassured.html

	@Test
	public void test1() {

		// specisfy base uri
		// RestAssured is predefined class
		RestAssured.baseURI = "https://reqres.in/";

		// reuest object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "api/users?page=2");

		// to print response in console

		String responsebody = response.getBody().asString();
		System.out.println("responsebody is :" + responsebody);

		// valiadations
		int statuscode = response.getStatusCode();
		System.out.println("status code is:" + statuscode);
		Assert.assertEquals(statuscode, 200);

		Headers headers = response.getHeaders();
		System.out.println(headers);
		System.out.println(response.getStatusLine());
		String statusLine = response.getStatusLine();

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test(priority = 2)
	public void test2onmylink() {

		System.out.println("*************testcase two***********");

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/pet/findByStatus?status=available");

		String responsebody = response.getBody().asString();
		System.out.println("responsebody is :" + responsebody);

		int statuscode = response.getStatusCode();
		System.out.println("status code is:" + statuscode);
		Assert.assertEquals(statuscode, 200);

		Headers hea = response.headers();
		

		System.out.println(response.getStatusLine());
		String statusLine = response.getStatusLine();

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		for(io.restassured.http.Header header: hea) {
			System.out.println(header.getName() + " "  + header.getValue());
		}
	}

}
