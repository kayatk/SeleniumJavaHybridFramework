package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Factory.BrowserFactory;

import java.time.Duration;

public class BaseClass {
   public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("LOG INFO: Start Browser - Before Method");
        BrowserFactory.startBrowser("Chrome","https://freelance-learn-automation.vercel.app/login");
        System.out.println("LOG INFO: Browser UP and Loaded the URL");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
