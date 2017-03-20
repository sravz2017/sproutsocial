package TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import BaseTest.BaseTest;
import Pages.LoginPage;
import Pages.SmartPage;

public class MessagesTest extends BaseTest {
	
	@AfterMethod(alwaysRun = true)
	public void after(ITestContext context){
		try{
		driver.quit();
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		}catch(Exception e){
			System.out.println("EXCEPTION: " + e);
		}
	}
	
	@Test(dataProvider="SSLoginDetails")
	public void testComposeMessage(String Username, String Password){
	    test = extent.startTest("ComposeTest");
	    test.log(LogStatus.INFO, "Starting Compose test");
		init("browser");
		//pages used during the test
		//login page
		LoginPage login = new LoginPage(driver, test);
		PageFactory.initElements(driver, login);
		
		  //Messages smart page
	    SmartPage message = new SmartPage(driver, test);
	    PageFactory.initElements(driver, message);
	    
		driver.get("https://app.sproutsocial.com/login");
	    login.SSlogin(Username, Password);
	    test.log(LogStatus.INFO, "Success login");
	    Assert.assertTrue(message.clickMessageTab(), "Unable to click on message tab" );
	    Assert.assertTrue(message.waitUntilComposeVisible(driver), "Unable to find compose");
	    Assert.assertTrue(message.clickCompose(), "Unable to click on Compose");
	    Assert.assertTrue(message.sendMessage(), "Unable to send text message");
	    Assert.assertTrue(message.clickSendMessageButton(), "Unable to click send");
	    Assert.assertTrue(login.sproutLogout(), "Unable to find Logout button");
	    test.log(LogStatus.PASS, "Test passed");
	    
	}
	
	@Test(dataProvider="SSLoginDetails")
	public void testReplyMessages(String Username, String Password){
		 test = extent.startTest("Message Test");
		 test.log(LogStatus.INFO, "Starting sending message test");
		init("browser");
		//pages used during the test
		//login page
		LoginPage login = new LoginPage(driver, test);
		PageFactory.initElements(driver, login);
		
		  //Messages smart page
	    SmartPage message = new SmartPage(driver, test);
	    PageFactory.initElements(driver, message);
	    
		driver.get("https://app.sproutsocial.com/login");
	    login.SSlogin(Username, Password);
	    test.log(LogStatus.INFO, "Success login");
	    Assert.assertTrue(message.clickMessageTab(), "Unable to click Messages Tab");
	    Assert.assertTrue(message.waitUntilMessageVisible(driver), "Unable to find messages");
	    Assert.assertTrue(message.clickReplyIcon(), "Unable to click on Reply icon");
	    Assert.assertTrue(message.sendReplyMessage(), "This is a reply text");
	    Assert.assertTrue(message.clickSendReplyMessage(), "Unable to click on send button");
	    test.log(LogStatus.PASS, "Test passed");
	} 
	
	@Test(dataProvider="SSLoginDetails")
	public void testScheduleMessages(String Username, String Password){
		test = extent.startTest("Publishing Test");
		 test.log(LogStatus.INFO, "Starting publishing test");
		init("browser");
		//pages used during the test
		//login page
		LoginPage login = new LoginPage(driver, test);
		PageFactory.initElements(driver, login);
		
		  //Messages smart page
	    SmartPage message = new SmartPage(driver, test);
	    PageFactory.initElements(driver, message);
	    
		driver.get("https://app.sproutsocial.com/login");
	    login.SSlogin(Username, Password);
	    test.log(LogStatus.INFO, "Success login");
	    Assert.assertTrue(message.clickMessageTab(), "Unable to click Messages Tab");
	    Assert.assertTrue(message.clickPublishingTab(), "Unable to click on Publishing tab");
	    Assert.assertTrue(message.clickScheduleMessage(), "Unable to click on schedule message button");
	    Assert.assertTrue(message.waitUntilScheduleViewVisible(driver), "Element is not visible");
	    Assert.assertTrue(message.sendScheduleMessage(), "Unable to send a message");
	    Assert.assertTrue(message.clickScheduleDate(), "Unable to find date");
	    Assert.assertTrue(message.clickScheduleButton(), "Unable to click schedule button");
	    Assert.assertTrue(login.sproutLogout(), "Unable to find Logout button");
	    test.log(LogStatus.PASS, "Test passed");
	}

}
