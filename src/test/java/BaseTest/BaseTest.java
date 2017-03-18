package BaseTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Util.ExtentManager;

public class BaseTest {
	
    public WebDriver driver;
    public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
 
    public void init(String browser){
    	
    	driver = new FirefoxDriver();
    	
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	test.log(LogStatus.INFO, "Opened Mozilla browser Successfully - " + browser);
    }
    
    @DataProvider(name ="SSLoginDetails")
    
    public static Object[][] getDataFromDataProvider(){
		return new Object[][]{
			{"qatests+homework@sproutsocial.com", "egQCorU7YuLE8guVsHnXMQJ+cTgt"}
		};
    	
    }
    
    
    
    
    
}
