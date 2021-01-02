package Scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import APIResources.GetAllAPIMethods;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;

import BasePack.Baselib;
import Pages.HomePage;
import Pages.WeatherPage;
import configManager.ConfigFileManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjectManager.PageObjectManager;

public class WeatherReportingComparator extends Baselib{
	
		
	private HomePage homePage;
	private WeatherPage weatherPage;
	private PageObjectManager pageObjectManager;
	
	
	@Test(testName="Compare Weather Data")
	public void verifyWeatherReportingComparator()
	{
		
		try {
		pageObjectManager=new PageObjectManager(driver);
		homePage=pageObjectManager.getHomePage();
		weatherPage=pageObjectManager.getWeatherPage();
		
		//Verify the Presence of Weather Menu on Home Page
		String menuName=ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("menu");
		homePage.verifyThePresenceOfMenu(menuName);
		
		//Click on Weather Menu
		homePage.clickOnTopMenu(menuName);
		
		//Search for the city on Weather Page
		String cityName=ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("cityName");
		weatherPage.searchForTheCity(cityName);
		
		//Validate the city is available on the Map with Temperature Information
		weatherPage.verifyCityInformationIsShowingOnGraph(cityName);
		
		//Validate that selecting any city on the map reveals the weather details
		weatherPage.verifySelectingAnyCityOnMapShowsTemperatureInfo(cityName);
		
		//Get the Temperature in Fahrenheit data from the Temperature Information
		String tempData=ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("temperatureData");
		String tempInDegreeValue=weatherPage.getTemperatureData(tempData);
		
		String apiID=ConfigFileManager.getInstance().getApplicationConfigData().getApplicationData("apiid");	
		String res=GetAllAPIMethods.getTemperatureUsingCityNameAPI(cityName, apiID);
		
		JsonPath jpath=new JsonPath(res);
		Float tempValueApi=jpath.get("main.temp");
		
		String variance=ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("allowedVariance");
		
		if((tempValueApi-Float.parseFloat(tempInDegreeValue))>2)
		{
			Assert.fail("Variance is greater than 2");
			
		}
		
		}catch(Exception e)
		{
			throw e;
		}
		
	}

}
