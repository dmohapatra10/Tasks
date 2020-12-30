package BasePack;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.IAddsMedia;

import Utilities.Utilss;

public class TestListener implements  ITestListener{
	
	
	private static ExtentReports extent=ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> logger=new ThreadLocal<ExtentTest>();
	
	public  void onTestStart(ITestResult result) {
	    
		ExtentTest	test=extent.createTest(result.getClass().getName()+"::"+result.getMethod().getMethodName());
		logger.set(test);
		
	  }
	
	
	
	public void onTestSuccess(ITestResult result) {
		
			String msg="<b>"+result.getMethod().getMethodName()+" Successful</b>";
			Markup m=MarkupHelper.createLabel(msg, ExtentColor.GREEN);
			logger.get().log(Status.PASS,m);
		  }
	
	
	public void onTestFailure(ITestResult result) {
		
		
		String exceptionMsg=Arrays.toString(result.getThrowable().getStackTrace());
	    
		WebDriver driver=((Baselib)result.getInstance()).driver;
	    Utilss utilss=new Utilss();
		logger.get().fail("<details><summary><b><font color=red>"+" Exception Occured, click To See Details:"+"</font></b></summary>"+exceptionMsg.replaceAll(",", "<br>")+"</details>\n");
		String path=utilss.getScreenshotOf(driver, result.getName());
		
			try {
				logger.get().addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  }

	
	public void onTestSkipped(ITestResult result) {
		String exceptionMsg=Arrays.toString(result.getThrowable().getStackTrace());
	    
		logger.get().log(Status.SKIP, MarkupHelper.createLabel("Test case ::"+result.getName()+" has been skipped", ExtentColor.YELLOW));
		logger.get().skip("<details><summary><b><font color=red>"+" Exception Occured, click To See Details:"+"</font></b></summary>"+exceptionMsg.replaceAll(",", "<br>")+"</details>\n");
	  }
	
	
	
	public void onStart(ITestContext context) {
	    // not implemented
	  }

	public void onFinish(ITestContext context) {
	    
		if(extent!=null)
		{
			extent.flush();
		}
	  }
}
