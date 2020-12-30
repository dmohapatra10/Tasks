package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DriverHelper;

public class WeatherPage extends DriverHelper{
	
	
	
	
	@FindBy(xpath="//input[@id='searchBox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//div[@class='leaflet-popup-content-wrapper']")
	private WebElement leafletPopUp;
	
	@FindBy(xpath="//div[@class='leaflet-popup-content']")
	private WebElement temperatureContent;
	
	@FindBy(xpath="//div[@class='leaflet-popup-content']//span/b")
	private List<WebElement> tempInfo;
	
	
	

	public WeatherPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void searchForTheCity(String city)
	{
		super.enterMethod();
		super.waitForElementPresent(searchTextBox);
		super.sendKeys(searchTextBox, city);
		WebElement cityLocator=driver.findElement(By.xpath("//input[@id='"+city+"']"));
		if(!cityLocator.isSelected())
		{
		super.click(cityLocator);
		}
		super.waitForJSLoad(10);
		super.exitMethod("searchForTheCity");
	}
	
	public void verifyCityInformationIsShowingOnGraph(String cityName)
	{
		super.enterMethod();
		super.waitForJSLoad(10);
		WebElement cityData=driver.findElement(By.xpath("//div[@class='outerContainer' and @title='"+cityName+"']"));
		Assert.assertTrue(super.verifyElementExists(cityData));
		super.exitMethod("verifyCityInformationIsShowingOnGraph");
	}
	
	public void clickOnTheCityOnGraph(String cityName)
	{
		super.enterMethod();
		
		WebElement cityData=driver.findElement(By.xpath("//div[@class='outerContainer' and @title='"+cityName+"']"));
		super.click(cityData);
		super.waitForElementPresent(leafletPopUp);
		super.exitMethod("clickOnCityDataOnGraph");
	}
	
	public void verifySelectingAnyCityOnMapShowsTemperatureInfo(String cityName)
	{
		super.enterMethod();
		this.clickOnTheCityOnGraph(cityName);
		Assert.assertTrue(temperatureContent.isDisplayed());
		super.exitMethod("verifySelectingAnyCityOnMapShowsTemperatureInfo");
	}
	
	public String getTemperatureData(String data)
	{
		super.enterMethod();
		super.waitForJSLoad(10);
		String tempKey;
		String tempValue;
		String tempData="";
		
		for(WebElement info:tempInfo)
		{
			tempKey=info.getText().trim().split(":")[0];
			tempValue=info.getText().trim().split(":")[1];
			if(tempKey.equalsIgnoreCase(data))
			{
			tempData=tempValue;
			break;
			}
		}
		
		super.exitMethod("getTemperatureData");
		return tempData;
	}

}
