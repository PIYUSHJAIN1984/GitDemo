import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class Sec30_240_ConsoleLogCapture {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
		driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys("2");

		// Write code in Listeners - OnTestFailure when console error comes

		// Get LogEntries object
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		
		// LogEntries object -> getAll method returns all logs in a list
		List<LogEntry> log = entry.getAll();
		
		//Iterating through list and printing each element
		// In framework move this info in Log4J file
		log.stream().forEach((c) -> System.out.println(c));

	}

}
