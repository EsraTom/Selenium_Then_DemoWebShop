package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addnew_Page;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC_001_AddAddress_Test extends BaseTest {
	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(2000);
		webdriverUtility.javaScriptScrollToElement(driver, homepage.getAddressBtn());
		homepage.getAddressBtn().click();

		Addresses_Page addresspage = new Addresses_Page(driver);
		webdriverUtility.javaScriptScrollToElement(driver,addresspage.getAddNewBtn());
		addresspage.getAddNewBtn().click();

		Addnew_Page addnewpage = new Addnew_Page(driver);
		addnewpage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addnewpage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addnewpage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));

		webdriverUtility.selectByVisibleText(addnewpage.getCountryDropDown(),
				fileUtility.readDataFromExcelFile("Sheet1", 1, 3));
		// addnewpage.getCountryDropDown().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",
		// 1, 3)); another way

		addnewpage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addnewpage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addnewpage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		addnewpage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		addnewpage.getSaveBtn().click();

		Thread.sleep(3000);
		webdriverUtility.webPageScreenshot(driver);
	}
}
