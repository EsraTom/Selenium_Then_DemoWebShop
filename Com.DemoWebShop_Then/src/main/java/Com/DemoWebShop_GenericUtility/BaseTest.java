package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sDriver; // use this in listeners utility
	public FileUtility fileUtility = new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomepage;
	public Login_Page loginpage;
	public Home_Page homepage;
	public WebDriverUtility webdriverUtility = new WebDriverUtility();

	@BeforeSuite
	public void bs() 
	{
		System.out.println("@BeforeSuite   Database is connected");
	}

	@BeforeTest
	public void bt() 
	{
		System.out.println("@BeforeTest   Reports started");
		spark =new ExtentSparkReporter(FrameWorkConstants.reporsPath);
		
		reports= new ExtentReports();
		
		reports.attachReporter(spark);
		
		test= reports.createTest("Address Module");
		
	}

	@BeforeClass
	public void bc() throws IOException 
	{
		System.out.println("@BeforeSuite   Browser launched");

		String browser = fileUtility.readDataFromPropertyFile("browserName");
		String url = fileUtility.readDataFromPropertyFile("baseUrl");
		
		//String browser=System.getProperty("browserName");

		if (browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		} else 
		{
			System.out.println("Enter valid Browser Name");
		}
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		
		
		
	}

	@BeforeMethod
	public void bm() throws IOException 
	{
		System.out.println("@BeforeMethod   Login");
		
		welcomepage =new Welcome_Page(driver);
		welcomepage.getLoginBtn().click();
		
		loginpage =new Login_Page(driver);
		
		loginpage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("emailId"));
		loginpage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginpage.getLoginBtn().click();
		
		 homepage= new Home_Page(driver);
	}

	@AfterMethod
	public void am() 
	{
		System.out.println("@AfterMethod   Logout");
		homepage.getLogoutBtn().click();
	}

	@AfterClass
	public void ac() throws InterruptedException 
	{
		System.out.println("@AfterClass   Browser closed");
		Thread.sleep(2000);
		driver.quit();
	}

	@AfterTest
	public void at() 
	{
		System.out.println("@AfterTest   Reports ended");
		reports.flush();
	}

	@AfterSuite
	public void as() 
	{
		System.out.println("@AfterSuite   Database is disconnected");
	}

}
