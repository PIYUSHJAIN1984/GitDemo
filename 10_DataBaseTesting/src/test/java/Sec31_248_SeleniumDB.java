import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec31_248_SeleniumDB {

	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");

		String host = "localhost";
		String port = "3306";
		String username = null;
		String password = null;

		// Connecting java to mySQL Server
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "admin");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("SELECT * FROM qadbt.employeeinfo where name=\"sam\"");
		while (rs.next()) {
			username = rs.getString("name");
			password = rs.getString("location");
		}

		driver.findElement(By.cssSelector("input#username")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
	}

}
