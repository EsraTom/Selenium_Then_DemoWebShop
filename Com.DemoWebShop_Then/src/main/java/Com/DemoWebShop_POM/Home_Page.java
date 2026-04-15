package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Log out")
	private WebElement logoutBtn;

	@FindBy(partialLinkText = "Addresses")
	private WebElement addressBtn;// Get getters

	public WebElement getLogoutBtn() 
	{
		return logoutBtn;
	}

	public WebElement getAddressBtn() 
	{
		return addressBtn;
	}
}
