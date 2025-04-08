package BaseClasses;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPostPage{
	WebDriver driver;

@FindBy(xpath="//input[@id='input-Username']") 
WebElement UserName;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtPassword; 

@FindBy(xpath="//input[@value='signin']") 
WebElement btnSignin;

@FindBy(xpath = "//h1[normalize-space()='You are successfully logged in']")
WebElement msgConfirmation;

@FindBy(xpath="//input[@value='Createpost']") 
WebElement btnCreatepost;

@FindBy(xpath="//input[@value='PostInbox']") 
WebElement PostInbox;

@FindBy(xpath="//input[@value='Postbutton']") 
WebElement btnPostbutton;



public void setUserName(String name) {
	UserName.sendKeys(name);

}
 
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}

public void clickSigninbutton() {
	btnSignin.click();
	
}

public void clickCreatepostbutton() {
	btnCreatepost.click();;
}

public void setPostmsg(String msg) {
	PostInbox.sendKeys(msg);
}

public void clickPostbutton() {
	btnPostbutton.click();
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}

public String getPostConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}
