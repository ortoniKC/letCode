package auth;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Authentication {

	public static void main(String[] args) {
	ChromeOptions op = new ChromeOptions();
	op.addExtensions(new File("auth.crx"));
	ChromeDriver driver = new ChromeDriver(op);
	driver.get("chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/popin.html");
	driver.findElementById("url").sendKeys("https://the-internet.herokuapp.com/basic_auth");
	driver.findElementById("username").sendKeys("admin");
	driver.findElementById("password").sendKeys("admin");
	driver.findElementByXPath("//button[.='Add']").click();
	driver.get("https://the-internet.herokuapp.com/basic_auth");
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
