package clipBoard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClipBoard {
	public static void main1(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://clipboardjs.com/");
		WebElement button = driver.findElementByCssSelector("#example-target button");
		String attribute = button.getAttribute("data-clipboard-target");
		System.out.println(attribute);
		WebElement target = driver.findElementByCssSelector(attribute);
		String value = target.getAttribute("value");
		System.out.println(value);
		driver.executeScript("window.open(\""+value+"\")");
	}
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://clipboardjs.com/");
		try {
			
			WebElement button = driver.findElementByCssSelector("#example-target button");
			button.click();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Object data = clipboard.getData(DataFlavor.stringFlavor);
			driver.executeScript("window.open(\""+data+"\")");
			System.out.println(data);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}
