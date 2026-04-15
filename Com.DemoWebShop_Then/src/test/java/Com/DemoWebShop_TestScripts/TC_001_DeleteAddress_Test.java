package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addnew_Page;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC_001_DeleteAddress_Test extends BaseTest {
	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Thread.sleep(2000);
		webdriverUtility.javaScriptScrollToElement(driver, homepage.getAddressBtn());
		homepage.getAddressBtn().click();
		
		Addresses_Page addresspage=new Addresses_Page(driver);
		addresspage.getDeleteBtn().click();
		Thread.sleep(2000);
		webdriverUtility.alertForAccept(driver);
		
		Thread.sleep(3000);
		webdriverUtility.webPageScreenshot(driver);
	}
}
