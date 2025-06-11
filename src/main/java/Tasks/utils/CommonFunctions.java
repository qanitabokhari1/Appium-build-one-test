package Tasks.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class CommonFunctions {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public CommonFunctions(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickElement(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ✅ Clear field and type text
    public void clearAndType(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            System.out.println("✅ Typed '" + text + "' into: " + locator);
        } catch (Exception e) {
            System.err.println("❌ Failed to type into: " + locator);
            e.printStackTrace();
        }
    }

    // ✅ Scroll until element is present (silent check)
    public void scrollToElement(By locator, String description) {
        boolean found = false;
        int maxScrolls = 10;
        int attempts = 0;

        while (!found && attempts < maxScrolls) {
            try {
                WebElement element = driver.findElement(locator);
                System.out.println("✅ Found element: " + description);
                found = true;
            } catch (Exception e) {
                scrollDown();
                attempts++;
            }
        }

        if (!found) {
            System.err.println("❌ Could not find element after scrolling: " + description);
        }
    }

    // ✅ Scroll and assert element is visible
    public void scrollUntilElementFound(By locator, String description) {
        boolean found = false;
        int maxScrolls = 10;
        int attempts = 0;

        while (!found && attempts < maxScrolls) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                System.out.println("✅ Element visible: " + description);
                found = true;
            } catch (Exception e) {
                scrollDown();
                attempts++;
            }
        }

        if (!found) {
            throw new RuntimeException("❌ Could not find element: " + description);
        }
    }

    // 👇 Internal swipe function
    private void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}
