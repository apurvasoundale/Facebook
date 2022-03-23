package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//button[@value='1']")
	private WebElement login;

	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenPassword;

	@FindBy(xpath="(//a[@role='button'])[1]")
	private WebElement creatNewAccount;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void clickonMobileNumber(String mobno)
	{
		mobileNumber.sendKeys(mobno);
	}
	
	public void clickonPassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void clickonLogin()
	{
		login.click();
	}

	public void clickonForgottenPassword()
	{
		forgottenPassword.click();
	}
	
	public void clickonCreatNewAccount()
	{
		creatNewAccount.click();
	}
}
