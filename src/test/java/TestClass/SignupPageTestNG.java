package TestClass;

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

import Pojo.Browser;
import pom.LoginPage;
import pom.SignUpPage;

public class SignupPageTestNG extends Browser{
	
	WebDriver driver;
	
	LoginPage loginpage;
	
	SignUpPage page;
	
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("beforesuite");
	}
	
	@BeforeTest
	@Parameters("browser")
	public void lounchBrowser(String browserName) 
	{
		System.out.println("lounchBrowser");
		if (browserName.equals("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			//driver = new ChromeDriver();
			
			driver = launchChromeBrowser();
		}
		if (browserName.equals("Opera"))
		{
//			System.setProperty("webdriver.opera.driver", "C:\\Users\\DELL\\Downloads\\operadriver_win64\\operadriver_win64\\operadriver.exe");
//			driver = new OperaDriver();
			
			driver = launchOperaBrowser();
		}
		if (browserName.equals("Edge"))
		{
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//			driver = new EdgeDriver();
			
			driver = launchMSEdgeBrowser();
		}
		if (browserName.equals("Firefox"))
		{
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//			driver = new FirefoxDriver();
			
			driver = launchFirefoxBrowser();
		}
	}
		
	@BeforeClass
	public void creatObjectofPOMClasses()
	{
		 loginpage = new LoginPage(driver);
		 page = new SignUpPage(driver);
	}
			

	
	@BeforeMethod
	public void signupPage() throws InterruptedException
	{
		System.out.println("signupPage");
		
		driver.navigate().to("https://www.facebook.com/");
		
		Thread.sleep(2000);
		
		loginpage = new LoginPage(driver);
		
		loginpage.clickonCreatNewAccount();
		
        page = new SignUpPage(driver);
        
        Thread.sleep(2000);
		
		page.clickonFirstName();
		Thread.sleep(3000);
		page.clickonsurname();
		Thread.sleep(3000);
		page.clickonmobileNumber();
		Thread.sleep(3000);
		page.clickonnewPassword();
		Thread.sleep(3000);
		page.clickonDay();
		Thread.sleep(2000);
		page.DayviaDropdown();
		Thread.sleep(3000);
		page.clickonMonth();
		Thread.sleep(2000);
		page.MonthviaDropdown();
		Thread.sleep(3000);
		page.clickonYear();
		Thread.sleep(2000);
		page.YearviaDropdown();
		Thread.sleep(3000);
		page.clickonFemale();
		
	}
	
	@Test
	public void verifySignupPage()
	{
		System.out.println("verifySignupPage");
		
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
		System.out.println("logOut");
	}
	
	@AfterClass
	public void clearPOMObject() 
	{
		loginpage = null;
		page = null;
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
