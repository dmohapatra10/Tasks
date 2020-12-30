package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BasePack.Baselib;

public class Utilss {
	
	public static TakesScreenshot ts;
	public static String screenShotPath=System.getProperty("user.dir")+"\\Screenshots";
	public String modifiedPath;
	
	public  String getScreenshotOf(WebDriver driver,String TestName)
	{
		try {
		ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		modifiedPath=screenShotPath+"\\"+TestName+System.currentTimeMillis()+".png";
		File dest=new File(modifiedPath);
		
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modifiedPath;
	}

}
