package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public void LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private By username = By.xpath("");


    public HomePage LoginToApp(String Credentials){
        driver.findElement(username).click();
        HomePage hm = new HomePage();
        return hm;
    }
}
