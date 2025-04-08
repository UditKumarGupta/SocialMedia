package TestCases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.Homepage;
import BaseClasses.UserRegistrationPage;
import util.ReportUtils;
import util.utility;

public class UserRegistrationClass {
	
public WebDriver driver;
String reportFilename;
ReportUtils reportUtils;
	
	@BeforeTest
	public void setup()
	{
		reportFilename = "Reports/testReport.html";
		reportUtils = new ReportUtils(reportFilename);
		 
		driver = utility.getBrowser("chrome"); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	}
	

	@Test
	public void verify_account_registration()
	{
		Homepage hp=new Homepage();
		hp.clickSignup();

		
		UserRegistrationPage regpage=new UserRegistrationPage();
		reportUtils.createATestCase("Verify user signup");
		
		regpage.setUserName("Tester");
		regpage.setEmail("tester@gmail.com"); 
		regpage.setPassword("Tester@123");
		regpage.setConfirmPassword("Tester@123");
		reportUtils.addTestLog(Status.INFO, "Click on usersign up button");
		regpage.clickRegisterbutton();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		reportUtils.addTestLog(Status.INFO, "Sigup Successfull");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		reportUtils.flushReport();
	}
	


}
