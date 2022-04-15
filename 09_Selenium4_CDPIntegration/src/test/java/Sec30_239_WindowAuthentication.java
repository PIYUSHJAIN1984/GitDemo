import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class Sec30_239_WindowAuthentication {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Predicate
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");

		// If authentication then cast driver before calling get function
		((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
	}
}
