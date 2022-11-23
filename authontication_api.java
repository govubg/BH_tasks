package API_restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authontication_api {
@Test(priority=1)
public void test1() {
	RestAssured.baseURI = "https://petstore.swagger.io/v2/";

/*/		//normally if username and pwd is asked initially then follow this bellow
	
	PreemptiveBasicAuthScheme authschem=  new PreemptiveBasicAuthScheme();
	authschem.setUserName("username");
	authschem.setPassword("provide-pwd");
	RestAssured.authentication=authschem;
	
	// then after this steps u can continue with the RequestSpecifications httprequest = RestAssured.given();
	
*/		

	
	// now since we are using this dummy and this dosent required any basic auth, but we have option to 
	// login so we will try implinemting this there.
	// link - https://petstore.swagger.io/#/
	// link - https://reqres.in/
	// link - https://www.youtube.com/watch?v=yDdBOspPp_c&list=PLUDwpEzHYYLuMRzT6LFq4r8DwKZdcqHmY&index=1
	
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "user/login");
	PreemptiveBasicAuthScheme authschem=  new PreemptiveBasicAuthScheme();
	authschem.setUserName("username");
	authschem.setPassword("provide-pwd");
	RestAssured.authentication=authschem;
	
	
	// so now we successfully logged in
	
}
}
