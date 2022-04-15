package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://rahulshettyacademy.com/sign_in/']")
	private WebElement Login;
	
	@FindBy(css="div[class='text-center'] h2")
	private WebElement title;
	
	@FindBy(css=".nav.navbar-nav.navbar-right")
	private WebElement headerLinks;
	
	@FindBy(css="div[class *='video-banner'] h3")
	private WebElement header;

	public LoginPage getLogin() {
		Login.click();
		LoginPage lp = new LoginPage(driver);
        return lp;
	}
	
	/*
	/ * public WebElement getLogin() 
	 * { return Login; 
	 * }
	 */
	
	public WebElement getTitle() {
		return title;
	}
	
	
	public WebElement getHeaderLinks() {
		return headerLinks;
	}
	
	public WebElement getHeader() {
		return header;
	}
	
	
	
}
