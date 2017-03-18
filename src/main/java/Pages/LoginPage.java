package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LoginPage {
	public WebDriver driver;
	public ExtentTest test;
	
	public LoginPage(){
		
	}
	
	public LoginPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	@FindBy(xpath ="//input[@type='email']")
	public WebElement loginEmail;
	
	@FindBy(xpath ="//input[@type='password']")
	public WebElement loginPwd;
	
	@FindBy(css ="button[class*='login-button']")
	public WebElement logInButton;
	
	
	//Logout
	
	@FindBy(xpath = "//div[@id='ss_topgear']")
	public WebElement settingsTab;
	
	@FindBy(xpath="//a[@id='sprout_logout']")
	public WebElement logoutButton;
	
	public String SSlogin(String Username, String Password){
		loginEmail.sendKeys(Username);
		loginPwd.sendKeys(Password);
		logInButton.click();
		test.log(LogStatus.INFO, "Successfully logged in to Sprout Social");
		return "";
		
	}
	
	public boolean sproutLogout(){
		try{
		settingsTab.click();
		logoutButton.click();
		test.log(LogStatus.INFO, "Logout Scuucess");
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
}
