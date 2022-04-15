package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sec18_132_testNG3 {

	@Parameters({ "URL", "username" })
	@Test(groups = { "Smoke" })
	public void webLoginCarLoan(String urlname, String username) {
		System.out.println("webLoginCarLoan");
		System.out.println(urlname + "  " + username);
	}

	@Test
	public void mobileLoginCarLoan() {
		System.out.println("mobileLoginCarLoan");
	}

	@Test(dataProvider = "getData")
	public void mobileLoginCarLoan1(String username, String password) {
		System.out.println("mobileLoginCarLoan1");
		System.out.println(username);
		System.out.println(password);

	}

	@Test
	public void AppLoginCarLoan() {
		System.out.println("AppLoginCarLoan");
	}

	@Test(groups = { "Smoke" })
	public void test5() {
		System.out.println("test5");
	}

	// Data Provider
	@DataProvider
	public Object[][] getData() {
		// Ist combination - username passowrd - good credit history
		// IInd combination - username passowrd - no credit history
		// IIIrd combination - username passowrd - fraud credit history

		Object[][] data = new Object[3][2];
		data[0][0] = "firstusername";
		data[0][1] = "password1";
		data[1][0] = "secondusername";
		data[1][1] = "passowrd2";
		data[2][0] = "thirdusername";
		data[2][1] = "password3";

		return data;
	}

}
