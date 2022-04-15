import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.fetch.Fetch;
import org.openqa.selenium.devtools.v97.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v97.network.model.ErrorReason;

public class Sec30_236_NetworkFailedRequest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		// To understand parameters of RequestPattern go to RequestPattern class
		RequestPattern pattern = new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty());

		// Understanding from Fetch.enable class what parameters are required and
		// creating values for those to use them.
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(pattern));

		// java.util.Optional<java.util.List<org.openqa.selenium.devtools.v97.fetch.model.RequestPattern>>
		// patterns, java.util.Optional<java.lang.Boolean> handleAuthRequests) {
		devTools.send(Fetch.enable(patterns, Optional.empty()));

		devTools.addListener(Fetch.requestPaused(), request -> {
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

	}

}
