package automateChromeExtension;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomateWeatherApp {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("1.0.90_0.crx"));

		ChromeDriver driver = new ChromeDriver(op);
		driver.get("chrome-extension://ngeokhpbgoadbpdpnplcminbjhdecjeb/popup.html");
		//		driver.manage().window().setSize(new Dimension(560, 526));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement location = driver.findElement(By.id("location"));
		String defaultLocation = location.getText();
		System.out.println(defaultLocation);
		driver.findElement(By.id("search_popup_page")).click();
		WebElement search = driver.findElementByXPath("//input[@aria-label=\"Enter the city or ZIP code\"]");
		search.sendKeys("Bangalore, Karnataka, India");
		Thread.sleep(5000);
		search.sendKeys(Keys.ENTER, Keys.ENTER);
		Thread.sleep(5000);
		System.out.println(location.getText());



	}

}
