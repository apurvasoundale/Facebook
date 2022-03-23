package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement firstName;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement surname;
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement newPassword;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;

	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement female;
	
	public SignUpPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonFirstName()
	{
		firstName.sendKeys("Apurva");
	}
	
	public void clickonsurname()
	{
		surname.sendKeys("Soundale");
	}
	
	public void clickonmobileNumber()
	{
		mobileNumber.sendKeys("9756734587");
	}
	
	public void clickonnewPassword()
	{
		newPassword.sendKeys("admin");
	}
	
	public void clickonDay()
	{
		day.click();
	}
	
	public void DayviaDropdown()
	{
		Select a = new Select(day);
		a.selectByIndex(8);
	}
	
	public void clickonMonth()
	{
		month.click();
	}
	
	public void MonthviaDropdown()
	{
		Select b = new Select(month);
		b.selectByVisibleText("Oct");
	}
	
	public void clickonYear()
	{
		year.click();
	}
	
	public void YearviaDropdown()
	{
		Select c = new Select(year);
		c.selectByValue("1996");
	}
	
	public void clickonFemale()
	{
		female.click();
	}
	

}
