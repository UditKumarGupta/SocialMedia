package BaseClasses;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage{
	WebDriver driver;

@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtName;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@value='Register']") 
WebElement btnRegister;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;


public void setUserName(String name) {
	txtName.sendKeys(name);

}
 
public void setEmail(String email) {
	txtEmail.sendKeys(email);

}


public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}

public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);

}


public void clickRegisterbutton() {
	btnRegister.click();
	
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}


}
