package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addnew_Page 
{
	public Addnew_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Find out the attributes from DOM for each field after logging in
	
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;

	@FindBy(id = "Address_LastName")
	private WebElement lastNameTextField;

	@FindBy(id = "Address_Email")
	private WebElement emailTextField;

	@FindBy(id = "Address_CountryId")
	private WebElement countryDropDown;

	@FindBy(id = "Address_City")
	private WebElement cityTextField;

	@FindBy(id = "Address_Address1")
	private WebElement address1TextField;

	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipCodeTextField;

	@FindBy(id = "Address_PhoneNumber")
	private WebElement phoneNumberTextField;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public WebElement getFirstNameTextField() 
	{
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() 
	{
		return lastNameTextField;
	}

	public WebElement getEmailTextField() 
	{
		return emailTextField;
	}

	public WebElement getCountryDropDown() 
	{
		return countryDropDown;
	}

	public WebElement getCityTextField() 
	{
		return cityTextField;
	}

	public WebElement getAddress1TextField() 
	{
		return address1TextField;
	}

	public WebElement getZipCodeTextField() 
	{
		return zipCodeTextField;
	}

	public WebElement getPhoneNumberTextField() 
	{
		return phoneNumberTextField;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
}
