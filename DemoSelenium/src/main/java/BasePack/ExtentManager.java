package BasePack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String projectPath=System.getProperty("user.dir");
    public static final String extentReportPath=projectPath+"\\ExtentReports\\Extent.html";
	public static ExtentReports createInstance()
	{
		
		
		reporter=new ExtentHtmlReporter(extentReportPath);
		reporter.config().setEncoding("utf-8");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Extent Report");
		reporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Username","dmohapatra");
		extent.attachReporter(reporter);
		
		return extent;
		
	}
	
	

}
