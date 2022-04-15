import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;

public class Sec30_231_MobileTestEmulator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		// send commands to CDP methods
		// CDP methods will invoke and get access to chrome dev tools
		// Refer to website
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/

		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

		driver.get("https://courses.rahulshettyacademy.com/");
		driver.findElement(By.cssSelector("button[class='navbar-toggle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li/a[contains(text(),'Courses')]")).click();

		// Note browser reset to default mode after executing last step in code. This is
		// expected behaviour

	}

}
