package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sec26_186_RediffHomePageClass {
	WebDriver driver;
	
	By searchBox=By.id("srchquery_tbox");

	public Sec26_186_RediffHomePageClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement searchBox() {
		return driver.findElement(searchBox);
	}
}
