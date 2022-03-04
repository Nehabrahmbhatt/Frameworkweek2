package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void doSendKey(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public boolean isElementDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    public WebElement waitForElementToVisible(By locator,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }
    public String waitForTitlePresent (String titleValue,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.titleIs(titleValue));
        return driver.getTitle();
    }
    public static void selectValueFromDropDown(WebElement element) {
        Select select = new Select(element);
        select.selectByIndex(16);
        Select select1 = new Select(element);
        select1.selectByValue("2");
        Select select2 = new Select(element);
        select2.selectByVisibleText("2022");

    }


}