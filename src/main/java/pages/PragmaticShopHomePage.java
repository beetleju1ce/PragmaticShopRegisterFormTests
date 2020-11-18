package pages;

import org.openqa.selenium.By;
import util.Browser;
/**
 * A class that represents the Home page
 * of shop.pragmatic.bg
 */
public class PragmaticShopHomePage {
    private static final By LOC_MY_ACCOUNT = By.cssSelector("li.dropdown a[href*= 'account/account']");
    private static final By LOC_MY_ACCOUNT_REGISTER = By.cssSelector("a[href*= 'account/register']");
    private static final By LOC_LOGIN = By.cssSelector("a[href*= 'account/login']");

    /**
     * A method that leads the user to the Home page of PragmaticShop
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/");
    }

    /**
     * A method that clicks on the button Register account
     */
    public static void selectRegisterAccount() {
        Browser.driver.findElement(LOC_MY_ACCOUNT).click();
        Browser.driver.findElement(LOC_MY_ACCOUNT_REGISTER).click();
    }

    /**
     * A method that clicks on the login button
     */
    public static void selectLogIn() {
        Browser.driver.findElement(LOC_MY_ACCOUNT).click();
        Browser.driver.findElement(LOC_LOGIN).click();
    }
}
