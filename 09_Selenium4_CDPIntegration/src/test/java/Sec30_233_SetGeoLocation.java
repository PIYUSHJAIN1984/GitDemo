import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Sec30_233_SetGeoLocation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		Map<String, Object> cordinates = new HashMap<String, Object>();
		cordinates.put("latitude", 28);
		cordinates.put("longitude", 2);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", cordinates);

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netfix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		System.out.println(driver.findElement(By.xpath("//h1[@data-uia='hero-title']")).getText());
	}

}
