package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.Browser;

/**
 * A class that represents the
 * Register account page
 */
public class RegisterAccountPage {
    private static final By LOC_FIRST_NAME = By.cssSelector("input#input-firstname");
    private static final By LOC_FIRST_NAME_ERROR_MESSAGE = By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]");
    private static final By LOC_LAST_NAME = By.cssSelector("input#input-lastname");
    private static final By LOC_LAST_NAME_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]");
    private static final By LOC_EMAIL = By.cssSelector("input#input-email");
    private static final By LOC_EMAIL_ERROR_MESSAGE = By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]");
    private static final By LOC_TELEPHONE = By.cssSelector("input#input-telephone");
    private static final By LOC_TELEPHONE_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]");
    private static final By LOC_PASSWORD = By.cssSelector("input#input-password");
    private static final By LOC_PASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]");
    private static final By LOC_PASS_CONFIRM = By.cssSelector("input#input-confirm");
    private static final By LOC_SUBSCRIBE_YES_BUTTON = By.cssSelector("label.radio-inline input[value = '1']");
    private static final By LOC_PRIVACY_POLICE_ALERT = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    private static final By LOC_AGREE_CHECKBOX = By.name("agree");
    private static final By LOC_CONTINUE = By.cssSelector("input.btn.btn-primary");

    /**
     * A method that successfully registers a new user
     * @param firstName - the first name of the user
     * @param lastName - the last name of the user
     * @param email - the user's email
     * @param telephone - the user's telephone
     * @param password - the user's password
     */
    public static void completeRegistration(String firstName, String lastName, String email, String telephone, String password){

        Browser.driver.findElement(LOC_FIRST_NAME).sendKeys(firstName);

        Browser.driver.findElement(LOC_LAST_NAME).sendKeys(lastName);

        Browser.driver.findElement(LOC_EMAIL).sendKeys(email);

        Browser.driver.findElement(LOC_TELEPHONE).sendKeys(telephone);

        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);

        Browser.driver.findElement(LOC_PASS_CONFIRM).sendKeys(password);

        WebElement radioButton = Browser.driver.findElement(LOC_SUBSCRIBE_YES_BUTTON);
        if(!radioButton.isSelected()){
            radioButton.click();
        }
        Assert.assertTrue(radioButton.isSelected());


        WebElement checkBox = Browser.driver.findElement(LOC_AGREE_CHECKBOX);
        if(!checkBox.isSelected()){
            checkBox.click();
        }

        Browser.driver.findElement(LOC_CONTINUE).click();
    }

    /**
     * A method that clicks on register account button
     * without filling the required fields
     */
    public static void registerWithBlankFields() {
        Browser.driver.findElement(LOC_CONTINUE).click();


        String actualAlertMessage = Browser.driver.findElement(LOC_PRIVACY_POLICE_ALERT).getText();
        WebElement checkBox = Browser.driver.findElement(LOC_AGREE_CHECKBOX);
        Assert.assertFalse(checkBox.isSelected());
        Assert.assertEquals(actualAlertMessage, "Warning: You must agree to the Privacy Policy!", "Missing alert");

        String actualErrorFirstName = Browser.driver.findElement(LOC_FIRST_NAME_ERROR_MESSAGE).getText();
        Assert.assertEquals( actualErrorFirstName,"First Name must be between 1 and 32 characters!", "Missing error message");

        String actualErrorLastName = Browser.driver.findElement(LOC_LAST_NAME_ERROR_MESSAGE).getText();
        Assert.assertEquals( actualErrorLastName,"Last Name must be between 1 and 32 characters!", "Missing error message");

        String actualErrorEmail = Browser.driver.findElement(LOC_EMAIL_ERROR_MESSAGE).getText();
        Assert.assertEquals( actualErrorEmail,"E-Mail Address does not appear to be valid!", "Missing error message");

        String actualErrorTelephone = Browser.driver.findElement(LOC_TELEPHONE_ERROR_MESSAGE).getText();
        Assert.assertEquals( actualErrorTelephone,"Telephone must be between 3 and 32 characters!", "Missing error message");

        String actualErrorPassword = Browser.driver.findElement(LOC_PASSWORD_ERROR_MESSAGE).getText();
        Assert.assertEquals( actualErrorPassword,"Password must be between 4 and 20 characters!", "Missing error message");

    }
}
