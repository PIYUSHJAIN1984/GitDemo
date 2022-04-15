package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sec26_186_RediffLoginClass {
//Login page implemented in normal page object style
	WebDriver driver;

	// Create a constructor and pass test case driver to local RediffLoginClass
	// driver using this keyword
	public Sec26_186_RediffLoginClass(WebDriver driver) {
		this.driver = driver;
	}

	By name = By.name("login");
	By password = By.id("password");
	By button = By.name("proceed");
	By homePage = By.xpath("//a[.='rediff.com']");

	public WebElement EmailID() {
		return driver.findElement(name);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement Click() {
		return driver.findElement(button);
	}

	public WebElement HomePage() {
		return driver.findElement(homePage);
	}
}