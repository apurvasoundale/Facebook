package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utiles.Utility;
import pom.LoginPage;
import pom.SignUpPage;

public class TestClass1 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
			
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.facebook.com/");
		
		Thread.sleep(3000);
		
		driver.get("https://paytm.com/"); 
		
		Thread.sleep(3000); 
		
		driver.navigate().back(); 
		
        String mobno = Utility.getDatafromExcel("Sheet1", 1,1);
		
		String pass = Utility.getDatafromExcel("Sheet1", 1,4);
		
		LoginPage loginpage = new LoginPage(driver);
		
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
		
		SignUpPage page = new SignUpPage(driver);
		
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
	
	

}
