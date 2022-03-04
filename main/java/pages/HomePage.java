package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.Utils;

public class HomePage {
    WebDriver driver;
    static Utils utils;
   // By logout = By.className("ico-logout");
   static By myAccount = By.className("ico-account");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

   // public boolean isLogoutPresent() {
      //  return utils.isElementDisplayed(logout);
   // }

   //public String getLogOutText() {
   // return utils.doGetText(logout);
   // }

    public static boolean isMyAccountPresent() {
        return utils.isElementDisplayed(myAccount);
    }
}
