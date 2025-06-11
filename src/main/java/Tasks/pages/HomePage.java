package Tasks.pages;

import Tasks.utils.CommonFunctions;
import Tasks.utils.Locators;
import io.appium.java_client.android.AndroidDriver;


public class HomePage {
    private AndroidDriver driver;
    private CommonFunctions commonFunctions;


    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.commonFunctions = new CommonFunctions(driver);
    }


    public void handlePermissions() {
        // Click the "Continue" button to proceed with permissions
        commonFunctions.clickElement(Locators.CONTINUE_BUTTON);

        // Click the "Allow" button to grant permissions
        commonFunctions.clickElement(Locators.ALLOW_BUTTON);
    }


    public void selectMultipleChoiceMode() {
        // Click on the Multiple Choice Mode button to enter the mode
        commonFunctions.clickElement(Locators.MULTIPLE_CHOICE_MODE);
    }


    public void selectWarpMode() {
        // Click on the Warp Mode button to enter the mode
        commonFunctions.clickElement(Locators.WARP_MODE);
    }


    public void navigateBackToHome() {
        // Navigate back to the previous screen (usually the Home screen)
        driver.navigate().back();
    }
}
