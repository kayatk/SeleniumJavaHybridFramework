package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

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
    
}
