import Pages.LoginPage;
import Pages.OrderPage;
import Reporting.TestRail;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Devices.Tools;
import Devices.Requests;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 25.09.2017.
 */
public class TestCases extends ChromeStart {
    private LoginPage loginsPage;
    private OrderPage ordersPage;

    private TestRail trReport;

    @BeforeTest
    protected void initDBPages() {
        loginsPage = new LoginPage(driver);
        ordersPage = new OrderPage(driver);
    }

    @BeforeClass
    protected void prepareTestRailRun() throws Exception {
        trReport = new TestRail();
        trReport.startRun(1, "Booklya Automation - " + new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date()));
    }

    @AfterMethod
    protected void reportResult(ITestResult testResult) throws Exception {
        String testDescription = testResult.getMethod().getDescription();
        trReport.setResult(Integer.parseInt(testDescription.substring(0, testDescription.indexOf("."))), testResult.getStatus());
       // trReport.setResult();
    }


    @AfterClass
    protected void closeTestRailRun() throws Exception {
        trReport.endRun();
    }

    @Test(description = "1.Success login to the account with correct data",priority = 2)
    protected void login(){
        loginsPage.successLogin();
        Assert.assertTrue(loginsPage.isPresent("a[class='userHeaderName']"));
    }

    @Test(description = "2.Success logout from the account",dependsOnMethods = "login",priority = 2)
    protected void unLogin(){
        loginsPage.unLog();
        Assert.assertTrue(loginsPage.isPresent("div[id='h-ta-ua-eb-t']"));
    }

    @Test(description = "3.Unsuccess login with incorrect password",priority = 1)
    protected void notLogin(){
        loginsPage.unSuccessLogin();
        Assert.assertFalse(loginsPage.isPresent("a[class='userHeaderName']"));
    }

}
