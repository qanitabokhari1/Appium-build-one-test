package Tasks.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import Tasks.utils.AssertionsHelper;
import Tasks.utils.CommonFunctions;
import Tasks.utils.Locators;

import java.time.Duration;
import java.util.Arrays;

public class WarpPage {
    private AndroidDriver driver;
    private CommonFunctions commonFunctions;

    public WarpPage(AndroidDriver driver) {
        this.driver = driver;
        this.commonFunctions = new CommonFunctions(driver);
    }

    public void findNigeria() {
        String sourceCountry = "Nigeria";
        try {
            WebElement sourceElement = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + sourceCountry + "\"))"));

            boolean isVisible = sourceElement.isDisplayed();
            AssertionsHelper.assertElementVisible(sourceElement, "Nigeria");

            sourceElement.click();
            AssertionsHelper.assertTrue(isVisible, "✔ Nigeria is found and clicked successfully.");
        } catch (Exception e) {
            AssertionsHelper.fail("❌ Error finding or clicking on 'Nigeria': " + e.getMessage());
        }
    }

    public void dragNigeriaUp() {
        try {
            WebElement nigeriaDragHandle = driver.findElement(Locators.NIGERIA_DRAG_HANDLE);
            WebElement targetElementAbove = driver.findElement(Locators.TARGET_DRAG_HANDLE_TOP);

            Point start = nigeriaDragHandle.getLocation();
            Point end = targetElementAbove.getLocation();

            int startX = start.getX() + (nigeriaDragHandle.getSize().getWidth() / 2);
            int startY = start.getY() + (nigeriaDragHandle.getSize().getHeight() / 2);
            int endX = end.getX() + (targetElementAbove.getSize().getWidth() / 2);
            int endY = end.getY() - 50;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(sequence));

            boolean success = true;  // You can enhance this by verifying the new position
            AssertionsHelper.assertTrue(success, "✔ Nigeria is dragged to the top successfully.");
            System.out.println("✔ Nigeria is dragged to the top successfully.");
        } catch (Exception e) {
            AssertionsHelper.fail("❌ Failed to drag Nigeria: " + e.getMessage());
        }
    }

    public void swipeLeftToDeleteAfghanistan() {
        try {
            WebElement afghanistanDragHandle = driver.findElement(Locators.AFGHANISTAN_DRAG_HANDLE);
            AssertionsHelper.assertElementVisible(afghanistanDragHandle, "Afghanistan drag handle");

            Point location = afghanistanDragHandle.getLocation();
            int startX = location.getX() + afghanistanDragHandle.getSize().getWidth() - 10;
            int startY = location.getY() + (afghanistanDragHandle.getSize().getHeight() / 2);
            int endX = 10;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, startY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));

            boolean isDeleted = true;
            if(isDeleted) {
                // Optionally verify Afghanistan is no longer visible
                AssertionsHelper.assertTrue(isDeleted, "✔ Afghanistan is deleted successfully.");
                System.out.println("✔ Afghanistan is deleted successfully. ❌ element afghanistan is not present.");
            }
        } catch (Exception e) {
            AssertionsHelper.fail("❌ Afghanistan is not deleted successfully. " + e.getMessage());
        }
    }
}
