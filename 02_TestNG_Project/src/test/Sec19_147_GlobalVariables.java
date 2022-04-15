package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Sec19_147_GlobalVariables {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\PJain15\\selenium_RahulShetty\\TestNG_Project\\data.properties");
		//Load method load file in reading mode
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));

		// To update the property of a parameter in .java class
		prop.setProperty("browser", "Safari");
		System.out.println(prop.getProperty("browser"));

		// To write back updated property value in data.properties FileOutPutStream to
		// be used
		//Store method used to write in property file
		FileOutputStream fs = new FileOutputStream(
				"C:\\Users\\PJain15\\selenium_RahulShetty\\TestNG_Project\\data.properties");
		prop.store(fs, null);

	}

}
