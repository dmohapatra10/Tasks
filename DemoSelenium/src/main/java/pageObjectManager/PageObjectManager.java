package pageObjectManager;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.WeatherPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private WeatherPage weatherPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public HomePage getHomePage()
	{
		return (homePage==null)?new HomePage(driver):homePage;
	}
	
	public WeatherPage getWeatherPage()
	{
		return (weatherPage==null)?new WeatherPage(driver):weatherPage;
	}

}
