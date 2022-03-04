package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;

    /**
     * This method is used to initialise the driver on the basis of browserName
     * @param browserName
     * @return driver
     */
    public WebDriver initialiseDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println(browserName + "Browser is invalid,then enter correct browser name");
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    /**
     * This method is to read the properties from config.properties file.
     * @return prop
     */

    public Properties initialiseProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\nehab\\IdeaProjects\\FramworkWeek2\\src\\test\\TestDeta\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("config file is missing,please check...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Properties cloud not be loaded");
            e.printStackTrace();
        }
        return prop;
    }
}