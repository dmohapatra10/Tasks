package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DriverHelper;

public class HomePage extends DriverHelper{
	
	
	@FindBy(xpath="//div[@class='topnav_cont']/a")
	private List<WebElement> topMenus;
	
	@FindBy(css="a#h_sub_menu")
	private WebElement showMoreMenuIcon;
	
	@FindBy(xpath="//div[@class='noti_wrap']//a[@class='notnow']")
	private WebElement notNow;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickNotNowLinkOnPageLoad()
	{
		super.enterMethod();
		super.waitForJSLoad(20);
	    super.waitForElementPresent(notNow);
	    super.click(notNow);
		super.exitMethod("clickNotNowLinkOnPageLoad");
	}
	public void clickOnShowMoreMenusIcon()
	{
		super.enterMethod();
		super.waitForElementToBeClickable(showMoreMenuIcon);
		super.click(showMoreMenuIcon);
		super.exitMethod("clickOnShowMoreMenusIcon");
	}
	
	public void verifyThePresenceOfMenu(String menuName)
	{
		super.enterMethod();
		super.waitForJSLoad(10);
		this.clickNotNowLinkOnPageLoad();
		super.click(showMoreMenuIcon);
		
		for(WebElement menus:topMenus)
		{
			if(menus.getText().trim().equalsIgnoreCase(menuName))
			{
				Assert.assertTrue(super.verifyElementExists(menus));
				break;
			}
		}
		
		super.exitMethod("verifyThePresenceOfMenu");
	}
	
	public void clickOnTopMenu(String menu)
	{
		super.enterMethod();
		for(WebElement menus:topMenus)
		{
			if(menus.getText().trim().equalsIgnoreCase(menu))
			{
				super.click(menus);
				break;
			}
		}
		super.exitMethod("clickOnTopMenu");
	}

}
