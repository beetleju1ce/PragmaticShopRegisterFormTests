package pages;

import org.openqa.selenium.By;
import util.Browser;

/**
 * A class that represents the login page
 */
public class AccountLogInPage {
    private static final By LOC_EMAIL = By.cssSelector("input#input-email");
    private static final By LOC_PASSWORD = By.cssSelector("input#input-password");
    private static final By LOC_LOGIN = By.cssSelector("input.btn.btn-primary");

    /**
     * A method that logs the user in
     * @param email - the user's email
     * @param password - the user's password
     */
    public static void returningCustomerLogin(String email, String password) {
        Browser.driver.findElement(LOC_EMAIL).sendKeys(email);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_LOGIN).click();
    }
}
