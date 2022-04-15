import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;

public class Sec30_232_CDPCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		Map deviceMetics = new HashMap();
		deviceMetics.put("width", 600);
		deviceMetics.put("height", 1000);
		deviceMetics.put("deviceScaleFactor", 50);
		deviceMetics.put("mobile", true);

		// Call directly CDP commands
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetics);

		driver.get("https://courses.rahulshettyacademy.com/");
		driver.findElement(By.cssSelector("button[class='navbar-toggle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li/a[contains(text(),'Courses')]")).click();

	}

}
