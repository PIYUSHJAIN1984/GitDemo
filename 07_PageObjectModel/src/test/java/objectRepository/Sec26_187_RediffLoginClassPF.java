package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sec26_187_RediffLoginClassPF {
	// Login page implemented in page factory model

	WebDriver driver;

	// Create a constructor and pass test case driver to local RediffLoginClass
	// driver using this keyword
	public Sec26_187_RediffLoginClassPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// By name = By.name("login");
	// By password = By.id("password");
	// By button = By.name("proceed");
	// By homePage=By.xpath("//a[.='rediff.com']");

	@FindBy(name = "login")
	WebElement name;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(name = "proceed")
	WebElement button;

	@FindBy(xpath = "//a[.='rediff.com']")
	WebElement homePage;

	public WebElement EmailID() {
		return name;
	}

	public WebElement Password() {
		return password;
	}

	public WebElement Click() {
		return button;
	}

	public WebElement HomePage() {
		return homePage;
	}

}
