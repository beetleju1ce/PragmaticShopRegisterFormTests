package negative;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PragmaticShopHomePage;
import pages.RegisterAccountPage;
import util.Browser;
import util.CommonVerification;

public class UnsuccessfulRegistrationTest {
    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void registerWithInvalidCredentials() {
        PragmaticShopHomePage.goTo();
        PragmaticShopHomePage.selectRegisterAccount();
        CommonVerification.verifyTitle("Register Account", "Oops, you're on the wrong page!");
        RegisterAccountPage.registerWithBlankFields();
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
