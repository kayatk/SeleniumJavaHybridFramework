package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import DataProvider.ExcelReader;
import Pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage login;

    @Test(dataProvider ="LoginDetail",dataProviderClass = ExcelReader.class)
    public void verifyLogin(String userName, String password){

        login =new LoginPage(driver);
        System.out.println("LOG INFO: Into the Login Method");
        System.out.println(userName+password);
    }
    @Test(dataProvider ="LoginDetail",dataProviderClass = ExcelReader.class)
    public void verifyLogins(String userName, String password){

        login =new LoginPage(driver);
        System.out.println("LOG INFO: Into the Login Method");
        System.out.println(userName+password);
    }
    
}
