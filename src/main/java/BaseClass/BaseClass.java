package BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DataProvider.ConfigReader;
import Factory.BrowserFactory;


public class BaseClass {
   public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("LOG INFO: Start Browser - Before Method");
        driver =BrowserFactory.startBrowser(ConfigReader.getProperty("browserName"),ConfigReader.getProperty("appURL")+"/login");
        System.out.println("LOG INFO: Browser UP and Loaded the URL");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("LOG INFO: Closing the Browser - After Method");
        BrowserFactory.closeBrowser(driver);
        System.out.println("LOG INFO: Session Closed");
    }
}
