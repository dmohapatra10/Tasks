package configManager;

public class ConfigFileManager {
	
	private static ConfigFileManager config=new ConfigFileManager();
	private static ApplicationConfigReader aReader;
	private static ConfigReader cReader;
	
	
	private ConfigFileManager()
	{
		
	}
	
	public static ConfigFileManager getInstance()
	{
		return config;
	}
	
	public ApplicationConfigReader getApplicationConfigData()
	{
		return (aReader==null)?new ApplicationConfigReader():aReader;
	}
	
	public ConfigReader getConfigReaderData()
	{
		return (cReader==null)?new ConfigReader():cReader;
	}

}
