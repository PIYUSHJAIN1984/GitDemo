import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.fetch.Fetch;

public class Sec30_235_NetWorkMocking {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		// Enables issuing of requestPaused events. A request will be paused until
		// client calls one of failRequest, fulfillRequest or
		// continueRequest/continueWithAuth.
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		// Request to backend will pause and once we modify the request we will proceed
		// Its a event so listener to be used
		devTools.addListener(Fetch.requestPaused(), request -> {

			// Replace parameter if its contains shetty with Badguy to mock data in UI
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockURL);

				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockURL),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
			} else { // If no url parameter matches then continue with request
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());

	}
}
