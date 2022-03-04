package pages;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilites.Utils;


public class RegisterPage {
    WebDriver driver;
    Utils utils;

    By register = By.className("ico-register");
    By gender = By.className("gender");
    By getGender = By.id("gender-female");
    By username = By.id("FirstName");
    By Lastname = By.id("LastName");
    By day = By.name("DateOfBirthDay");
    By Month = By.name("DateOfBirthMonth");
    By Year = By.name("DateOfBirthYear");
    By emailId = By.id("Email");
    By company = By.id("Company");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    //By loginButton = By.className("ico-login");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        utils.waitForTitlePresent(title, 10);
        System.out.println("register page title is:" + title);
        return title;
    }

    //public HomePage clickOnRegisterPage() {

    public HomePage doRegister(String firstname, String lastname) {
        utils.waitForElementToVisible(username, 10);
        driver.findElement(register).click();
        driver.findElement(gender).isDisplayed();
        driver.findElement(getGender).click();
        driver.findElement(username).sendKeys("Neha");
        driver.findElement(Lastname).sendKeys("Brahmbhatt");
        utils.waitForElementToVisible(day, 10);
        driver.findElement(day);
        utils.waitForElementToVisible(Month, 10);
        driver.findElement(Month);
        utils.waitForElementToVisible(Year, 10);
        driver.findElement(Year);
        driver.findElement(emailId).sendKeys("abcd@abc.com");
        driver.findElement(company).sendKeys("unify");
        driver.findElement(password).sendKeys("1234abcd");
        driver.findElement(confirmPassword).sendKeys("1234abcd");
        utils.waitForElementToVisible(registerButton, 10);
        driver.findElement(registerButton).click();

        /*utils.doClick(register);
        utils.doClick(getGender);
        utils.doSendKey(username, firstname);
        utils.doSendKey(Lastname, lastname);
        //utils.doClick(day);
        WebElement Value = null;
        utils.selectValueFromDropDown(null);
        //utils.doClick(Year);
        String Email = null;
        utils.doSendKey(emailId, null);
        utils.doSendKey(company, String.valueOf(company));
        utils.doSendKey(password, String.valueOf(password));
        utils.doSendKey(confirmPassword, String.valueOf(confirmPassword));
        utils.doClick(registerButton);*/






        return new HomePage(driver);

    }

}

// public void doRegister(String firstname, String lastname) {




