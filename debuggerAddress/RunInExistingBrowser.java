package debuggerAddress;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunInExistingBrowser {

    // debuggerAddress=localhost:52718}
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:52718");
        ChromeDriver driver = new ChromeDriver(options);
        Capabilities capabilities = driver.getCapabilities();
        Map<String, Object> asMap = capabilities.asMap();
        asMap.forEach((key, value) -> {
            System.out.println("Key " + key + " Value " + value);
        });

        String attribute = driver.findElement(By.id("clearMe")).getAttribute("value");
        System.out.println(attribute);
        driver.findElement(By.id("getMe")).clear();

        // driver.get("https://letcode.in/edit");
        // driver.findElement(By.id("fullName")).sendKeys("Koushik");

    }

}