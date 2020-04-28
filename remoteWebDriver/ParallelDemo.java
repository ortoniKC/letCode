package remoteWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ParallelDemo {
	RemoteWebDriver driver;
	
	@Test
	void openGoogle() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		driver.
//		driver.getScreenshotAs(outputType);
//		driver.executeScript(script, args)
	}

	@Test
	void openLetCode() {
		driver = new FirefoxDriver();
		driver.get("https://letcode.in/");
	}
	
	
	

}
