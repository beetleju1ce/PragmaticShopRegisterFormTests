package positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountLogInPage;
import pages.PragmaticShopHomePage;
import util.Browser;
import util.CommonVerification;

public class LogInAfterRegistrationTest {
    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void logIn() {
        PragmaticShopHomePage.goTo();
        PragmaticShopHomePage.selectLogIn();
        CommonVerification.verifyTitle("Account Login", "You are on the wrong page");
        AccountLogInPage.returningCustomerLogin("blaklsjd@abg.com", "plok123!");
        CommonVerification.verifyTitle("My Account", "You are on the wrong page!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
