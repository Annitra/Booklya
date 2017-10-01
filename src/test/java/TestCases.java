import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Devices.Tools;
import Devices.Requests;

/**
 * Created by user on 25.09.2017.
 */
public class TestCases extends ChromeStart {
    @Test(description = "Success login to the account",priority = 2)
    protected void login(){
        LoginPage loginsPage = new LoginPage(driver);
        loginsPage.successLogin();
        Assert.assertTrue(loginsPage.isPresent("a[class='userHeaderName']"));
    }

//    @Test(description = "Success registration")
//    protected void successRegistration(){
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.doRegistration();
//    }

    @Test(description = "Success logout from the account",dependsOnMethods = "login")
    protected void unLogin(){
        LoginPage loginsPage = new LoginPage(driver);
        loginsPage.unLog();
        Assert.assertTrue(loginsPage.isPresent("div[id='h-ta-ua-eb-t']"));
    }

    @Test(description = "Unsuccess login",priority = 1)
    protected void notLogin(){
        LoginPage loginsPage = new LoginPage(driver);
        loginsPage.unSuccessLogin();
        Assert.assertFalse(loginsPage.isPresent("a[class='userHeaderName']"));
    }
}
