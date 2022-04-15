import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;

public class Sec30_234_LogNetworkActivity {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		// Create sessions
		devTools.createSession();

		// Enables network tracking, network events will now be delivered to the client.
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// Request will be send from frontend to backend
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request res = request.getRequest();
			// System.out.println(res.getUrl());
		});

		// Event will get fired when API send response to client(browser)
		// event responseReceived is fired we are adding listener so response object
		// From response object we are getting res and using it we are getting url and
		// status
		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			// System.out.println(res.getUrl());
			if (res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + " is failed with code " + res.getStatus());
			}
		});

		driver.get("https://courses.rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Courses')]")).click();
	}

}
