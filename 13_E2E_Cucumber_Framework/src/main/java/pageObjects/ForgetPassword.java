package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPassword {
	public WebDriver driver;

	public ForgetPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement emailAddress;

	@FindBy(css = "input[type='submit']")
	WebElement sendInstructions;

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getInstructions() {
		return sendInstructions;
	}

}
