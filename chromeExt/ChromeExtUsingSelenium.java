package chromeExt;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ChromeExtUsingSelenium {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("app.crx"));
        ChromeDriver driver = new ChromeDriver(opt);
        getData(driver);
        // option
        driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/options.html");
        WebElement lanSel = driver.findElementById("language-selector");
        new Select(lanSel).selectByVisibleText("Hindi");
        driver.findElement(By.id("save-btn")).click();
        getData(driver);

    }

    private static void getData(ChromeDriver driver) throws InterruptedException {
        // popup page
        driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/browser_action.html");
        driver.findElementById("query-field").sendKeys("define");
        driver.findElementById("define-btn").click();
        Thread.sleep(5000);
        String text = driver.findElementByClassName("headword").getText();
        System.out.println(text);
    }

}