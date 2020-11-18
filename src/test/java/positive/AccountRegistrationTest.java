package positive;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PragmaticShopHomePage;
import pages.RegisterAccountPage;
import util.Browser;
import util.CommonVerification;

public class AccountRegistrationTest {
    @BeforeMethod
    public void setup() {
        Browser.open("chrome");
    }

    @Test
    public void registerAccount() {
        PragmaticShopHomePage.goTo();
        PragmaticShopHomePage.selectRegisterAccount();
        CommonVerification.verifyTitle("Register Account", "Oops, you're on the wrong page!");
        RegisterAccountPage.completeRegistration("pesho", "peshov", "plqk" + RandomString.make(4) + "abv.bg", "05986577436", "plok123!");
        CommonVerification.verifyTitle("Your Account Has Been Created!", "Oops, you're on the wrong page!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
