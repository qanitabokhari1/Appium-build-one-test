package Tasks.pages;

import Tasks.utils.AssertionsHelper;
import Tasks.utils.CommonFunctions;
import Tasks.utils.Locators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selendroid_ShowProgressBar {
    public AndroidDriver driver;
    public CommonFunctions commonFunctions;

    public Selendroid_ShowProgressBar(AndroidDriver driver) {
        this.driver = driver;
        this.commonFunctions = new CommonFunctions(driver);
    }

    public void handlePermissions() {
        // Click the "Continue" button to proceed with permissions
        commonFunctions.clickElement(Locators.SELENDROID_CONTINUE);
        // Click the "Allow" button to grant permissions
        commonFunctions.clickElement(Locators.SELENDROID_OK);
    }

    public void clickWaitingButtonAndWaitForLoad() {

        Selendroid_homePage selendroidHomePage = new Selendroid_homePage(driver);

        // Click the waiting button using UiAutomator
        commonFunctions.clickElement(Locators.SHOW_PROGRESS_BAR);
        // Wait until the page is loaded - replace this with an actual locator that appears when loaded
        By pageLoadedLocator = (Locators.INPUT_USERNAME);
        waitForPageToLoad(pageLoadedLocator, "Waiting Button Test Form Page");
        selendroidHomePage.registerNewUser();
        commonFunctions.waitForSeconds(2);
        displayToast();
    }

    public void displayToast() {
        WebElement toast = driver.findElement(Locators.TOAST_BAR);
        commonFunctions.clickElement(Locators.TOAST_BAR);
        AssertionsHelper.assertTrue(toast.isDisplayed(),toast.getText());
        System.out.println(toast.getText());

        WebElement window_toast = driver.findElement(Locators.DISPLAY_WINDOW_POPUP);
        commonFunctions.clickElement(Locators.DISPLAY_WINDOW_POPUP);

        WebElement dismiss = driver.findElement(Locators.DISMISS);
        dismiss.click();
        AssertionsHelper.assertTrue(window_toast.isDisplayed(),window_toast.getText());
        System.out.println(window_toast.getText());

        WebElement focus = driver.findElement(Locators.FOCUS);
        focus.click();
        AssertionsHelper.assertTrue(focus.isDisplayed(),focus.getText());
        System.out.println(focus.getText());
    }

    private void waitForPageToLoad(By locator, String description) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            AssertionsHelper.assertTrue(element.isDisplayed(), description + " loaded successfully");
            System.out.println(description + " loaded successfully");
        } catch (Exception e) {
            AssertionsHelper.fail(description + " did not load within expected time.");
        }
    }
}
