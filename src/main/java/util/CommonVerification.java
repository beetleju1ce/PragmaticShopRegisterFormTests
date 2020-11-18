package util;

import org.testng.Assert;

/**
 * A class that represents Common verification message
 */
public class CommonVerification {

    /**
     * Method that verifies the expected title is shown
     * @param expectedTitle - the expected title
     * @param errorMessage - error message in case there is a difference between expected and actual titles
     */
    public static void verifyTitle(String expectedTitle, String errorMessage) {
        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, errorMessage);
    }
}
