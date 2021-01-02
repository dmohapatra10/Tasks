package APIConstantResources;

public enum APIConstants {
	
	getTempUsingCityName("/data/2.5/weather");
	
	String resource;
	APIConstants(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
