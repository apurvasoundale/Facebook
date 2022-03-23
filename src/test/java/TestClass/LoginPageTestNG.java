package TestClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pojo.Browser;
import Utiles.Utility;
import pom.LoginPage;

public class LoginPageTestNG extends Browser{
	
	WebDriver driver;
	
	WebDriver wait;
	
	SoftAssert soft;
	
	String testID;
	
	//static ExtentTest test;
	
//	static ExtentHtmlReporter reporter;
	
	LoginPage loginpage;
	
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("beforesuite");
	}
	
	@BeforeTest
	@Parameters("browser")
	public void lounchBrowser(String browserName) 
	{
//		reporter = new ExtentHtmlReporter("test-output"+ File.separator+"ExtendReport"+File.separator+"extendReport.html");
//		ExtendReports extend = new ExtendReports();
//		extendattachReporter(reporter);
		
		
		
		System.out.println("lounchBrowser");
		if (browserName.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		if (browserName.equals("Opera"))
		{
			driver = launchOperaBrowser();
		}
		if (browserName.equals("Edge"))
		{
			driver = launchMSEdgeBrowser();
		}
		if (browserName.equals("Firefox"))
		{
			driver = launchFirefoxBrowser();
		}
	
	
	}

	@BeforeClass
	public void creatObjectofPOMClasses()
	{
		 loginpage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void loginPage() throws InterruptedException, IOException 
	{
		System.out.println("loginPage ");
		
		driver.navigate().to("https://www.facebook.com/");
		
		String mobno = Utility.getDatafromExcel("Sheet1", 1,1);
		
		String pass = Utility.getDatafromExcel("Sheet1", 1,4);
		
        loginpage = new LoginPage(driver);
        
		
		Thread.sleep(3000);
		
		loginpage.clickonMobileNumber(mobno);
		Thread.sleep(3000);
		loginpage.clickonPassword(pass);
		Thread.sleep(3000);
		loginpage.clickonLogin();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		loginpage.clickonForgottenPassword();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		loginpage.clickonCreatNewAccount();
		
		Thread.sleep(3000);
	}

	@Test
	public void verifyLoginPage() 
	{
		System.out.println("verifyLoginPage");
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
        String title = driver.getTitle();
		
		System.out.println(title);
		
		if (url.equals(url))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		if (title.equals(title))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}

	@AfterMethod
	public void logOut()
	{
		System.out.println("logOut ");
	}

	@AfterClass
	public void clearPOMObject() 
	{
		loginpage = null;
	}
	
	@AfterTest
	public void closeBrowser() 
	{
		System.out.println("closeBrowser");
		driver.quit();
		driver = null;
		System.gc();
	}
	
	@AfterSuite
	public void aftersuite() 
	{
		System.out.println("aftersuite");
	}

}
