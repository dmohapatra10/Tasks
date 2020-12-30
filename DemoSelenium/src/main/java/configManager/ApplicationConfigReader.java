package configManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ApplicationConfigReader {

	private Properties prop;
	private final String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\config\\application.properties";
	private FileInputStream fis;
	
	public ApplicationConfigReader()
	{
		prop=new Properties();
		try {
			fis=new FileInputStream(propPath);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public String getApplicationData(String key)
	{
		String data=prop.getProperty(key);
		if(data!=null)
			return data;
		else
			throw new RuntimeException("There is no value associated with Key:"+key);
		
	}
	
}
