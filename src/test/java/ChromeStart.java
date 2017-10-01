import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 25.09.2017.
 */
public class ChromeStart {
    WebDriver driver;

    @BeforeTest
    protected void startChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\Booklya\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    void AfterM(ITestResult testResult){
        System.out.println(testResult.getMethod().getDescription());
        System.out.println(testResult.isSuccess());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
