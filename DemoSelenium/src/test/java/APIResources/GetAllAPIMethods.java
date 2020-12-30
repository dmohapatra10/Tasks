package APIResources;

import org.testng.Assert;

import configManager.ConfigFileManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllAPIMethods {
	
	private static String baseURI=ConfigFileManager.getInstance().getApplicationConfigData().getApplicationData("apiurl");
	
	public static String getAPI(String cityName, String apiKey)
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=baseURI;
		RequestSpecification httpRequest = RestAssured.given().queryParam("q", cityName).queryParam("appid", apiKey).log().all();
		Response response = httpRequest.get("/data/2.5/weather");
		int resCode=response.getStatusCode();
		Assert.assertEquals(200, resCode);
		return response.getBody().asString();
	}
	

}
