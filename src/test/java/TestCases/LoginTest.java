package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage login;

    @Test
    public void verifyLogin(){

        login =new LoginPage(driver);
        System.out.println("LOG INFO: Into the Login Method");
    }
    
}
