package Tasks.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Tasks.utils.AssertionsHelper;
import Tasks.utils.CommonFunctions;
import Tasks.utils.Locators;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoicePage {

    private AndroidDriver driver;
    private WebDriverWait wait;
    private CommonFunctions commonFunctions;
    private List<String> selectedItems = new ArrayList<>();

    public MultipleChoicePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.commonFunctions = new CommonFunctions(driver);
    }

    public void selectRandomRadioButtons(int count) {
        String[] items = {"Brad Mehldau", "Joshua Redman", "Chick Corea", "Kurt Rosenwinkel", "Miles Davis"};

        for (int i = 0; i < count && i < items.length; i++) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"" + items[i] + "\")")));

            AssertionsHelper.assertTrue(
                    element != null && element.isDisplayed(),
                    "Radio button for '" + items[i] + "' not found or not visible."
            );
            System.out.println("✔ '" + items[i] + "' radio button is visible and will be selected.");
            element.click();
            selectedItems.add(items[i]);
        }
    }


    public void deleteSelectedItems() {
        for (int i = 0; i < selectedItems.size(); i++) {
            WebElement deleteIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DELETE_ICON));

            AssertionsHelper.assertTrue(
                    deleteIcon != null && deleteIcon.isDisplayed(),
                    "Delete icon not visible for item index " + i
            );

            deleteIcon.click();

        }
    }

    public void verifyItemsDeleted() {
        boolean allItemsDeleted = true;

        for (String item : selectedItems) {
            List<WebElement> elements = driver.findElements(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + item + "\")"));

            boolean isItemDeleted = elements.isEmpty();

            AssertionsHelper.assertTrue(
                    isItemDeleted,
                    "❌ '" + item + "' was NOT deleted."
            );

            if (isItemDeleted) {
                System.out.println("✔ '" + item + "' has been deleted successfully.");
            } else {
                allItemsDeleted = false;
            }
        }

        // Final assertion to ensure all deletions occurred
        AssertionsHelper.assertTrue(
                allItemsDeleted,
                "❌ Final check failed: Not all selected items were deleted."
        );

        if (allItemsDeleted) {
            System.out.println("✔ Final check passed: All selected items were deleted and are no longer present.");
        } else {
            System.out.println("❌ Final check failed: Some selected items are still present.");
        }
    }
}
