package BaseClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage{
	WebDriver driver;
 

@FindBy(id="Signup") 
WebElement Signup;

@FindBy(id="Signin") 
WebElement Signin;


public void clickSignup()
{
	 Signup.click();
}

public void clickSignin()
{
	Signin.click();
}


}
