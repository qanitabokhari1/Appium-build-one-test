package Tasks.pages;

import Tasks.utils.CommonFunctions;
import Tasks.utils.Locators;
import Tasks.utils.AssertionsHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class Selendroid_SelectLongPage {
    public AndroidDriver driver;
    public CommonFunctions commonFunctions;
    public String imageUrl = "https://images.pexels.com/photos/1324803/pexels-photo-1324803.jpeg";

    public Selendroid_SelectLongPage(AndroidDriver driver) {
        this.driver = driver;
        this.commonFunctions = new CommonFunctions(driver);
    }

    public void handlePermissions() {
        // Click the "Continue" button to proceed with permissions
        commonFunctions.clickElement(Locators.SELENDROID_CONTINUE);
        // Click the "Allow" button to grant permissions
        commonFunctions.clickElement(Locators.SELENDROID_OK);
    }

    private void scrollDownSlightly() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.6);
        int halfY = (int) (size.height * 0.45);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, halfY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    private void scrollUntilElementFound(By locator, String description) {
        boolean found = false;
        int maxScrolls = 10;
        int scrolls = 0;

        while (!found && scrolls < maxScrolls) {
            try {
                WebElement element = driver.findElement(locator);
                AssertionsHelper.assertElementVisible(element, description + " is visible");
                System.out.println("✅ Successfully found element: " + description);
                found = true;
            } catch (Exception e) {
                scrollDownSlightly();
                scrolls++;
            }
        }

        if (!found) {
            AssertionsHelper.fail("❌ Could not find element: " + description);
        }
    }

    public void selectLongContentAndFormPage() {

        // Navigate to WebView
        commonFunctions.clickElement(Locators.BUTTON_START_WEBVIEW);
        // Select Long Content Page
        commonFunctions.waitForSeconds(5);
        commonFunctions.clickElement(Locators.SPINNER_TEST_DATA);
        commonFunctions.clickElement(Locators.LONG_CONTENT_PAGE);

        // Scroll to Normal Link and click it
        scrollUntilElementFound(Locators.NORMAL_LINK, "Normal link");
        commonFunctions.clickElement(Locators.NORMAL_LINK);

        // Navigate to Form Page
        commonFunctions.waitForSeconds(2);
        commonFunctions.clickElement(Locators.SPINNER_TEST_DATA);
        commonFunctions.clickElement(Locators.FORM_PAGE);

        // Fill Email field
        WebElement email = driver.findElement(Locators.EMAIL_INPUT);
        email.sendKeys("Hello there");

        commonFunctions.waitForSeconds(1);
        // Checkbox and dropdowns
        commonFunctions.clickElement(Locators.CHECKBOX_CHECKY);

        commonFunctions.clickElement(Locators.DROPDOWN_ONE);
        commonFunctions.clickElement(Locators.DROPDOWN_FOUR);

        commonFunctions.waitForSeconds(1);
        commonFunctions.clickElement(Locators.MULTI_SELECT);
        commonFunctions.clickElement(Locators.SELECT_HAM);
        commonFunctions.clickElement(Locators.OK_BUTTON);

        commonFunctions.waitForSeconds(1);
        commonFunctions.clickElement(Locators.ZERO_SELECTED_0);
        commonFunctions.clickElement(Locators.SELECT_1);
        commonFunctions.clickElement(Locators.OK_BUTTON);

        commonFunctions.waitForSeconds(1);
        commonFunctions.clickElement(Locators.ZERO_SELECTED_1);
        commonFunctions.clickElement(Locators.SELECT_1);
        commonFunctions.clickElement(Locators.OK_BUTTON);

        commonFunctions.waitForSeconds(1);
        commonFunctions.clickElement(Locators.DROPDOWN_ONE_INSTANCE_TWO);
        commonFunctions.clickElement(Locators.DROPDOWN_FOUR);

        commonFunctions.waitForSeconds(1);
        commonFunctions.clickElement(Locators.EMPTY_CLICK_VIEW);
        commonFunctions.clickElement(Locators.DROPDOWN_TEXT1);

        commonFunctions.clickElement(Locators.CHECKBOX_CHEESE);

        commonFunctions.waitForSeconds(1);
        WebElement working = driver.findElement(Locators.WORKING_INPUT);
        working.clear();
        working.sendKeys("Working Appium");

        commonFunctions.waitForSeconds(2);
        scrollUntilElementFound(Locators.CHECKBOX_WITH_LABEL, "Checkbox With Label");

        commonFunctions.waitForSeconds(1);
        WebElement withText = driver.findElement(Locators.WITH_TEXT_INPUT);
        withText.clear();
        withText.sendKeys("Example Appium");

        commonFunctions.waitForSeconds(1);
        WebElement emptyArea = driver.findElement(Locators.EMPTY_TEXT_AREA);
        emptyArea.clear();
        emptyArea.sendKeys("empty Appium");

        commonFunctions.waitForSeconds(1);
        WebElement inputWithText = driver.findElement(Locators.INPUT_WITH_TEXT);
        inputWithText.clear();
        inputWithText.sendKeys("Filled text");
        commonFunctions.waitForSeconds(1);



//        WebElement urlInputField = driver.findElement(Locators.IMAGE_FIELD);
//        urlInputField.sendKeys(imageUrl);
//
//        WebElement uploadBtn = driver.findElement(Locators.UPLOAD_BUTTON);
//        uploadBtn.click();
//
//        WebElement redirectBtn = driver.findElement(Locators.REDIRECT_BUTTON);
//        redirectBtn.click();
//        commonFunctions.clickElement(Locators.SELECT_ONE);


        commonFunctions.waitForSeconds(1);
        WebElement name1 = driver.findElement(Locators.NAME_INPUT);
        name1.clear();
        name1.sendKeys("Testing");

        commonFunctions.waitForSeconds(1);
        WebElement id1 = driver.findElement(Locators.ID_NAME1);
        id1.clear();
        id1.sendKeys("123");

        commonFunctions.waitForSeconds(1);
        WebElement id2 = driver.findElement(Locators.ID_NAME2);
        id2.clear();
        id2.sendKeys("245");

        commonFunctions.waitForSeconds(1);
        WebElement name2 = driver.findElement(Locators.NAME_INPUT_TWO);
        name2.clear();
        name2.sendKeys("Appium");


        commonFunctions.waitForSeconds(1);
        WebElement checkLabel = driver.findElement(Locators.CHECKBOX_WITH_LABEL);
        checkLabel.click();

        commonFunctions.waitForSeconds(1);
        WebElement search = driver.findElement(Locators.SEARCH_GADGET);
        search.clear();
        search.sendKeys("All good");

        commonFunctions.waitForSeconds(1);
        WebElement submitBtn = driver.findElement(Locators.SUBMIT_BUTTON);
        submitBtn.click();
    }
}



