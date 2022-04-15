package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.Sec26_186_RediffHomePageClass;
import objectRepository.Sec26_186_RediffLoginClass;
import objectRepository.Sec26_187_RediffLoginClassPF;

public class LoginApplication {
	
	@Test
	public void Login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		Sec26_187_RediffLoginClassPF rd = new Sec26_187_RediffLoginClassPF(driver);
		rd.EmailID().sendKeys("dd@gmail.com");
		rd.Password().sendKeys("vvv");
		rd.Click().click();
		Thread.sleep(4400);
		rd.HomePage().click();
		
		Sec26_186_RediffHomePageClass r=new Sec26_186_RediffHomePageClass(driver);
		r.searchBox().sendKeys("budget");
		
		
	}

}
