package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to url");
	}

	@Test
	public void titleValidation() {
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		Assert.assertTrue(l.getHeaderLinks().isDisplayed());
		log.info("successfully validated text message");
	}

	@Test
	public void validateTitle() {
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
