package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.Homepage;
import BaseClasses.UserPostPage;
import util.ReportUtils;
import util.utility;

public class UserPost {
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
	
	@Test(priority = 1)
	public void verify_user_signin()
	{
		reportUtils.createATestCase("Verify user signup");
		
		Homepage hp=new Homepage();
		hp.clickSignin();

		
		UserPostPage regpage=new UserPostPage();
		reportUtils.addTestLog(Status.INFO, "providing username and password");
		
		regpage.setUserName("Tester"); 
		regpage.setPassword("Tester@123");
		regpage.clickSigninbutton();
		
		reportUtils.addTestLog(Status.INFO, "Click on usersign in button");
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "You are Successfully logged in!");
		reportUtils.addTestLog(Status.INFO, "Sigin Successfull");
	}
	
	@Test(priority = 2)
	public void verify_user_post()
	{

		reportUtils.createATestCase("Verify user can create a post");
		
		UserPostPage post=new UserPostPage();
		
		reportUtils.addTestLog(Status.INFO, "clicking on create post button");
		post.clickCreatepostbutton(); 
		post.setPostmsg("This is my first post.");
		
		post.clickPostbutton();
		reportUtils.addTestLog(Status.INFO, "clicking on post button");
		
		String confmsg=post.getPostConfirmationMsg();
		Assert.assertEquals(confmsg, "Your post is successfully created");
		reportUtils.addTestLog(Status.INFO, "post is successfully created");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		reportUtils.flushReport();
	}

}
