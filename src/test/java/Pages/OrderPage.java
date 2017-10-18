package Pages;

import Devices.Tools;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 04.10.2017.
 */
public class OrderPage extends Tools {
    public OrderPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    String bookSearch = "Java";
    String countOfBooks = "2";

    @FindBy(id="mainSearchInput")
    private WebElement searchField;
    @FindBy(css ="div[data-cart-item='eyJ0eXBlIjoiYm9vayIsImlkIjoiMTU2MDY3IiwiZXh0cmEiOltdfQ==']")
    private WebElement buyButton;
    @FindBy(id="106049")
    //@FindBy(className = "div.popupTitle")
  //  private WebElement popUpWindow;
    private WebElement countField;
    @FindBy(className = "span.minus")
    private WebElement minusCount;
    @FindBy(className = "span.plus")
    private WebElement plusCount;
    @FindBy(className = "a.goToPurchaseFromCart buttonStyle")
    private WebElement orderButton;

    public boolean isPresent(String input){
        try {
            WebElement presentElement = driver.findElement(By.className(input));
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e ) {
            return false; }

    }

    private void order(String count){
        driver.get("https://www.booklya.ua/book/zateryannyy-mir-the-lost-world-cd-3-y-uroven-156067/");
        buyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
       // alert.accept();
       // driver.switchTo().frame(popUpWindow);
//        plusCount.click();
//        minusCount.click();
//        countField.sendKeys(count);
       // orderButton.click();
    }

    public void buyBook(){
        order(countOfBooks);
    }
}

