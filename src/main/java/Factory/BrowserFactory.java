package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver startBrowser(String browser,String appURL){
        WebDriver driver=null;

        if(browser.equalsIgnoreCase("Chrome")){
            driver= new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox")) {
            driver= new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            driver= new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Safari")){
            driver= new SafariDriver();
        }
       
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void closeBrowser(WebDriver driver){
        driver.quit();
    }
    
}
