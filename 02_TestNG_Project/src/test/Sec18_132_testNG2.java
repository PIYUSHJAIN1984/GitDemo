package test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sec18_132_testNG2 {
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@BeforeTest
	public void preRequiste() {
		System.out.println("Initial first test execution");
	}
	
	@Test(groups={"Smoke"})
	public void test4() {
		System.out.println("test4");
		Assert.assertTrue(false);
	}
	

}
