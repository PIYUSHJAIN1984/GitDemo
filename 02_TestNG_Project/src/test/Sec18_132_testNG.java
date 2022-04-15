package test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sec18_132_testNG {
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@AfterTest
	public void lastExecution() {
		System.out.println("Last test execution");
	}
	
	@BeforeSuite
	public void firstSuite() {
		System.out.println("First test execution in suite");
	}
	
	@AfterSuite
	public void lastSuite() {
		System.out.println("Last test execution in suite");
	}
	
	@Test(groups={"Smoke"})
	public void test3() {
		System.out.println("test3");
	}
	
	@Test
	public void test6() {
		System.out.println("test6");
	}
	
	@Test(dependsOnMethods= {"test6"})
	public void test7() {
		System.out.println("test7");
	}

}
