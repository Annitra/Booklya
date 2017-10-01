package Pages;

import Devices.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 25.09.2017.
 */
public class LoginPage extends Tools {
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    String bookShop="https://www.booklya.ua/";
    String login = "anna.matkovska.k@gmail.com";
    String password = "PasswordQA";

    //To find elements for login
    @FindBy(id="h-ta-ua-eb-t")
    private WebElement buttonLogin;
    @FindBy(css="div>input[data-field='login']")
    private WebElement emailField;
    @FindBy(css="div>input[data-field='pass']")
    private WebElement passwordField;
    @FindBy(css="div.loginBtn")
    private WebElement buttonSubmit;

    public boolean isPresent(String input){
        try {
            WebElement presentElement = driver.findElement(By.cssSelector(input));
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e ) {
            return false; }

    }

    //To find element for logout
    @FindBy(css ="div.userLogoutBtn")
    private WebElement logOut;

    private  void doLogin(String passInput){
        driver.get(bookShop);
        buttonLogin.click();
        emailField.sendKeys(login);
        passwordField.sendKeys(passInput);
        buttonSubmit.click();
            }



    public void successLogin(){
        doLogin(password);
    }
    public void unSuccessLogin(){
        doLogin("password");
    }

    public void unLog(){
        logOut.click();
    }

}
