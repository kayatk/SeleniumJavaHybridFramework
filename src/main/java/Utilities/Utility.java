package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    public static String getDateTime(){
        return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
    }

    public static void captureScreenShot(WebDriver driver, WebElement element) throws IOException{
        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/Screenshots/Element_Screenshot_"+getDateTime()+".png");
        FileHandler.copy(src, dest); 
    }

    public static void captureScreenShot(WebDriver driver) throws IOException{
        TakesScreenshot ts = (TakesScreenshot)driver;
       File src= ts.getScreenshotAs(OutputType.FILE);
       File dest =new File(System.getProperty("user.dir")+"/Screenshots/Screenshot"+getDateTime()+".png");
       FileHandler.copy(src, dest);
    }

    public static void waitForSeconds(int seconds){
          try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        Utility.highlightElement(driver, element);
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("LOG Info: Element Click () function Failed. Trying Action click");
            Actions act = new Actions(driver);
                try {
                    act.click(driver.findElement(locator)).perform();
                } catch (Exception r) {
                    System.out.println("LOG Info: Action class Click () function Failed. Trying Javascript click");
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    js.executeScript("arguments[0].click();",driver.findElement(locator));
                }
        }
       
    }

    public static WebElement highlightElement(WebDriver driver,WebElement element){
        System.out.println("LOG Info: Highlighting the Element");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
        waitForSeconds(1);
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');",element);
        return element;
    }

    public static WebElement getElement(WebDriver driver,By locator){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element =wait.until(ExpectedConditions.elementToBeClickable(locator));
        highlightElement(driver, element);
        return element;
    }
    
}
