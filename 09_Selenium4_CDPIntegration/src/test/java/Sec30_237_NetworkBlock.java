import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;

import com.google.common.collect.ImmutableList;

public class Sec30_237_NetworkBlock {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		System.out.println(driver.findElement(By.cssSelector(".sp")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

}
