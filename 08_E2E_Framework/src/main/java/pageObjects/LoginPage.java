package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement userName;

	@FindBy(id = "user_password")
	WebElement password;

	@FindBy(name = "commit")
	WebElement logInBtn;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement forgetPwd;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return logInBtn;
	}
	
	public ForgetPassword getForgetPwdLink() {
		forgetPwd.click();
		ForgetPassword fp=new ForgetPassword(driver);
		return fp;
	}
}
