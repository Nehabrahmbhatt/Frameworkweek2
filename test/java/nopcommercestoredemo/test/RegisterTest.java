package nopcommercestoredemo.test;

import base.BasePage;
import com.nopcomercestore.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Properties;

public class RegisterTest {
    BasePage basePage;
    Properties prop;
    RegisterPage registerPage;
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() {
        Assert.assertEquals(registerPage.getPageTitle(), Constants.REGISTER_PAGE_TITLE,
                "Register page title not correct");
    }


    //@Test
    //  public void verifyLoginButtonTest() {
    // Assert.assertTrue(HomePage.isMyAccountPresent(), "myAccount link is not displayed");
    //}

    @Test(priority = 2)
    public void userRegisterDetails() {
        registerPage.doRegister(prop.getProperty("firstname"), prop.getProperty("lastname"));
        registerPage.doRegister(prop.getProperty("email"), prop.getProperty("password"));
        registerPage.doRegister(prop.getProperty("register"), prop.getProperty("gender"));
        registerPage.doRegister(prop.getProperty("company"), prop.getProperty("confirmPassword"));
        registerPage.doRegister(prop.getProperty("day"), prop.getProperty("month"));
        registerPage.doRegister(prop.getProperty("year"), prop.getProperty("registerButton"));

    }

    @Test(priority = 3)
    public void verifyMyAccountPresentTest() {
        Assert.assertTrue(HomePage.isMyAccountPresent(), "myAccount link is not displayed");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
