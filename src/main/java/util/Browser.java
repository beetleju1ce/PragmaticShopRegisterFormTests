package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

/**
 * A class that represents the browser
 */
public class Browser {
   public static WebDriver driver;

    /**
     * Method that opens a browser
     * @param browserType - the type of browser to be opened
     */
    public static void open(String browserType){
        switch(browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            default:
                throw new RuntimeException("The browser that is chosen " + browserType + " is not a valid browser!");
        }
    }

    public static void quit() {
        Browser.quit();
    }
}
