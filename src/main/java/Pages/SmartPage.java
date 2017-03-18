package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SmartPage{
	public WebDriver driver;
	public ExtentTest test;
	
	public SmartPage(){
		
	}
	public SmartPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	//locators
	
	//Compose
	@FindBy (css=".compose")
	public WebElement compose;
	
	@FindBy (xpath="//div/textarea[@tabindex='2']")
	public WebElement textArea;
	
	@FindBy (xpath = "//div/button[@tabindex='6']")
	public WebElement sendMsgButton;
	
	//Messages tab
	@FindBy(xpath = "//nav[@name='menu']/ul/li/a[@class='menu-item-link messages']")
	public WebElement messagesTab;
	
	@FindBy(xpath ="//div[@id='recent_msgs']/div/section/article")
	public List<WebElement> articles;
	
	//section>ul>li:nth-child(1)>a:nth-child(1)
	@FindBy(xpath = "//section/ul/li/a[@title='Reply']")
	public List<WebElement> replyMessageIcon;
	
	@FindBy(xpath="//div/textarea[@tabindex='2']")
	public WebElement sendReplyTextarea;
	
	@FindBy(xpath ="//div/button[@tabindex='6']")
	public WebElement sendReplyButton;
	
	
	//Publishing Tab
	@FindBy(xpath = "//nav[@name='menu']/ul/li/a[@class='menu-item-link publishing']")
	public WebElement publishingTab;
	
	@FindBy(xpath ="//div/a[@class='auxcontent-action action primary-action js-schedule-message']")
	public WebElement scheduleMessageButton;
	
	@FindBy(xpath="//div[@id='composing']/div[@class='compose-view']")
	public WebElement scheduleView;
	
	@FindBy(xpath = "//div/textarea[@tabindex='2']")
	public WebElement scheduleMsgTextarea;
	
	@FindBy (xpath="//div[@class='schedule-calendar']/div/div/table/tbody/tr[5]/td[2]")
	public WebElement scheduleDate;
	
	@FindBy(xpath ="//div[@class='actions']/button/span")
	public WebElement scheduleButton;
	
	
	
	//Methods
	public boolean waitUntilComposeVisible(WebDriver driver){
		try{
			new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(compose));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean waitUntilMessageVisible(WebDriver driver){
		try{
			new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfAllElements(articles));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean clickCompose(){
		try{
			compose.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sendMessage(){
		try{
			textArea.sendKeys("This is a test");
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickSendMessageButton(){
		try{
			sendMsgButton.click();
			test.log(LogStatus.INFO, "Successfully sent message");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickMessageTab(){
		try{
			messagesTab.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickReplyIcon(){
		try{
			WebElement secondReplyIcon = replyMessageIcon.get(1);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", secondReplyIcon);	
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sendReplyMessage(){
		try{
			sendReplyTextarea.sendKeys("This is a reply text");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickSendReplyMessage(){
		try{
			sendReplyButton.click();
			test.log(LogStatus.INFO, "Successfully sent a reply message to a tweet");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	//Publishing Methods
	
	public boolean waitUntilScheduleViewVisible(WebDriver driver){
		try{
			new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(scheduleView));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickPublishingTab(){
		try{
			publishingTab.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean clickScheduleMessage(){
		try{
			scheduleMessageButton.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sendScheduleMessage(){
		try{
			scheduleMsgTextarea.sendKeys("This is a Scheduled test");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickScheduleDate(){
		try{
			scheduleDate.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickScheduleButton(){
		try{
			scheduleButton.click();
			test.log(LogStatus.INFO, "Scheduled a tweet for future date");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}


