package de.mohamed.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testbase {

	public static WebDriver driver;
	public String BaseUrl;

	@BeforeClass
	public void setup() {

		if (driver == null) {

			System.setProperty("webdriver.chrome driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			BaseUrl = "https://letskodeit.teachable.com/p/practice";
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(BaseUrl);
		}

	}

	@AfterClass
	public void teardown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		if (driver != null) {
			driver.close();
		}
	}
}
