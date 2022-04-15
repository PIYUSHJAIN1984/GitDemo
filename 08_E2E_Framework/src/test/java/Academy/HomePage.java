package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgetPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName()) ;

	@BeforeTest
	public void initialize() throws IOException {
		// driver is from base class
		driver = initializeDriver();
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		// Create object of class and invoke methods in it
		LandingPage l = new LandingPage(driver);
		LoginPage lp=l.getLogin();
		
		//l.getLogin().click();
		//LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info(text);
		lp.getLoginBtn().click();
		
//		ForgetPassword fp=lp.getForgetPwdLink();
//		fp.getEmailAddress().sendKeys("ab@gmail.com");
//		fp.getInstructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		// Rows stand for how many different data types test should run
		// column indicates how many values sending per test
		Object[][] data = new Object[2][3];
		// row 0
		data[0][0] = "ab@gmail.com";
		data[0][1] = "ab";
		data[0][2] = "test1";

		// row1
		data[1][0] = "ab1@gmail.com";
		data[1][1] = "ab1";
		data[1][2] = "test2";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
