import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.model.ConnectionType;
import org.openqa.selenium.devtools.v97.network.Network;

public class Sec30_238_NetworkSpeed {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// +ve scenario to emulate network conditions
		/*
		 * devTools.send( Network.emulateNetworkConditions(false, 3000, 20000, 10000,
		 * Optional.of(ConnectionType.ETHERNET)));
		 * 
		 * long startTime = System.currentTimeMillis();
		 * driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 * driver.findElement(By.xpath("//a[@role='button']")).click(); long endTime =
		 * System.currentTimeMillis(); System.out.println(endTime - startTime);
		 */

		// To know issue with browser when in emulateNetworkConditions true is set to
		// make internet offline

		devTools.send(
				Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));

		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

}
