package BasePack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.DriverHelper;
import Utilities.EventHandler;
import Utilities.Utilss;
import configManager.ConfigFileManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baselib {
	
	public WebDriver driver2;
	public static String projectPath=System.getProperty("user.dir");
    public static final String extentReportPath=projectPath+"\\ExtentReports\\Extent.html";	
	protected DriverHelper helper;
	public Utilss utilss;
	protected EventFiringWebDriver driver;
	public FileInputStream fstream;
	
	
	protected Baselib()
	{	
		
	     helper=new DriverHelper(this.driver);
		 utilss=new Utilss();	 
	}
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void initialize(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver2=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver2=new FirefoxDriver();
		}
		driver = new EventFiringWebDriver(driver2);
		EventHandler handler = new EventHandler();
		driver.register(handler);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigFileManager.getInstance().getApplicationConfigData().getApplicationData("url"));		
		
	}
	
	
	@AfterSuite
	public void closeConnection()
	{
		driver.quit();
		
	}

}
