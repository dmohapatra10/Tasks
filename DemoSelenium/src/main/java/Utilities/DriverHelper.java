package Utilities;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configManager.ConfigFileManager;

public class DriverHelper {
	
	
	public WebDriver driver;
	public long explicitWaitTime=20;
	public long implicitWaitTime=20;
	public WebDriverWait wait;
	public JavascriptExecutor jsExe;
	public Robot robot;
	public Actions action;
	

	
	
	
	public DriverHelper(WebDriver driver)
	{		
		this.driver=driver;	
		this.initializeWaitTimes();		
		
	}
	
	public void enterMethod() {
	    final int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
	    final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName().trim();
	    final String methodAndLine = "(" + methodName + ":" + lineNumber + ")";
	    System.out.println(("ENTER --> " + methodAndLine));
	  }
	
	public void exitMethod(final String msg) {
	    final int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
	    final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName().trim();
	    final String methodAndLine = "(" + methodName + ":" + lineNumber + ")";
	    if ((msg == null) || ("".equals(msg.trim()))) {
	      System.out.println(("EXIT --> " + methodAndLine));
	    } else {
	      System.out.println(("EXIT --> " + methodAndLine + " -> " + msg));
	    }
	  }
	
    public void initializeWaitTimes()
    {
	this.explicitWaitTime=Long.valueOf(ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("EXPPLICIT_WAIT_TIME"));
	this.implicitWaitTime=Long.valueOf(ConfigFileManager.getInstance().getConfigReaderData().getPropertyConfigData("IMPLICITY_WAIT_TIME"));			
			
    }
		
	public void click(WebElement ele)
	{
		this.waitForElementToBeClickable( ele);
		ele.click();
	}
	
	public void jsClick(WebElement ele)
	{
		this.waitForElementToBeClickable(ele);
		jsExe=((JavascriptExecutor)driver);
		jsExe.executeScript("arguments[0].click();", ele);
	}
	
	public void sendKeys(WebElement ele, String msg)
	{
		this.waitForElementPresent(ele);
		ele.sendKeys(msg);
	}
	
	public void sendKeysJS(WebElement ele, String msg)
	{
		this.waitForElementPresent(ele);
		jsExe=((JavascriptExecutor)driver);
		jsExe.executeScript("arguments[0].value='"+msg+"';", ele);
	}
	
	
	public void mouseClick(WebElement ele)
	{
		this.waitForElementToBeClickable( ele);
		action =new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}
	
	public void pressEnterKey(WebElement ele)
	{
		this.waitForElementToBeClickable(ele);
		ele.sendKeys(Keys.ENTER);
	}
	
	
	
	public boolean verifyElementExists(WebElement ele) {
		boolean status=false;
		this.waitForElementPresent(ele);
		if(ele.isDisplayed()) {
			status=true;
		
		}
		return status;		
	}
	
 
	public void implicitilyWait(long time)
	{
		driver.manage().timeouts().implicitlyWait(this.explicitWaitTime, TimeUnit.SECONDS);
	}
	
	public void waitForElementPresent(WebElement ele)
	{
		wait=new WebDriverWait(driver,this.explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebElement ele)
	{
		wait=new WebDriverWait(driver,this.explicitWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void waitForJSLoad(long time) 
	{
		while (true)
	    {
	        Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
	        if (ajaxIsComplete){
	            break;
	        }
	        try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	

}
