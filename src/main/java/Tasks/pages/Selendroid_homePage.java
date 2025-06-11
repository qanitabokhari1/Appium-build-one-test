package Tasks.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import Tasks.utils.CommonFunctions;
import Tasks.utils.AssertionsHelper;
import Tasks.utils.Locators; // <--- IMPORTANT: import your Locators

public class Selendroid_homePage {

    protected String car_name = "Bens";
    protected String input_user = "Qanita Bokhari";
    protected String car_company = "Mercedes";
    protected String check_result = "result_text";
    protected String email_field = "qanita@123gmail.com";
    protected String password_field = "12345";


    public AndroidDriver driver;
    public CommonFunctions commonFunctions;

    public Selendroid_homePage(AndroidDriver driver) {
        this.driver = driver;
        this.commonFunctions = new CommonFunctions(driver);
    }

    public void handlePermissions() {
        // Click the "Continue" button to proceed with permissions
        commonFunctions.clickElement(Locators.SELENDROID_CONTINUE);
        // Click the "Allow" button to grant permissions
        commonFunctions.clickElement(Locators.SELENDROID_OK);
    }

    public void startUserRegisterration() {
        // Navigate to Registration Form
        commonFunctions.clickElement(Locators.START_USER_REGISTRATION);
        // Fill Username
        commonFunctions.waitForSeconds(2);
    }

    public void registerNewUser() {
        WebElement usernameField = driver.findElement(Locators.INPUT_USERNAME);
        usernameField.click();
        usernameField.sendKeys(input_user);

        // Fill Email
        WebElement emailField = driver.findElement(Locators.INPUT_EMAIL);
        emailField.click();
        emailField.sendKeys(email_field);

        // Fill Password
        WebElement passwordField = driver.findElement(Locators.INPUT_PASSWORD);
        passwordField.click();
        passwordField.sendKeys(password_field);

        // Fill Name (Clear then Enter)
        WebElement nameField = driver.findElement(Locators.INPUT_NAME);
        nameField.click();
        nameField.clear();
        nameField.sendKeys(input_user);

        // Scroll until Register button is visible
        driver.findElement(Locators.SCROLL_TO_REGISTER_BUTTON);

        // Select preferred programming language
        commonFunctions.clickElement(Locators.PREFERRED_PROGRAMMING_LANGUAGE_DROPDOWN);
        commonFunctions.clickElement(Locators.PREFERRED_LANGUAGE_PHP);

        // Tick the checkbox
        WebElement checkbox = driver.findElement(Locators.INPUT_ADDS_CHECKBOX);
        checkbox.click();

        // Assertion: checkbox is selected
        AssertionsHelper.assertTrue(checkbox.isDisplayed(), checkbox.getText());

        // Click Register User button
        WebElement registerButton = driver.findElement(Locators.BTN_REGISTER_USER);
        registerButton.click();

        commonFunctions.waitForSeconds(5);
        WebElement registerBtn = driver.findElement(Locators.BUTTON_REGISTER_USER);
        registerBtn.click();
    }
    public void selectCar() {
        // Click on the WebView radio button
        commonFunctions.clickElement(Locators.BUTTON_START_WEBVIEW);
        // Click on the spinner (dropdown)
        commonFunctions.clickElement(Locators.SPINNER_TEST_DATA);
        // Click on "'Say Hello'-Demo" option
        commonFunctions.clickElement(Locators.SAY_HELLO_DEMO_OPTION);
        // Click on the name input field
        WebElement nameInput = driver.findElement(Locators.NAME_INPUT_WEBVIEW);
        nameInput.clear();
        nameInput.sendKeys(car_name);
        // Assert input text is correctly filled
        AssertionsHelper.assertTrue(nameInput.isDisplayed(), nameInput.getText());
        System.out.println(nameInput.getText());

        // Click on "Volvo"
        commonFunctions.clickElement(Locators.SELECT_VOLVO);
        // Click on "Mercedes"
        commonFunctions.clickElement(Locators.SELECT_MERCEDES);
        // Click on "Send me your name!"
        WebElement sendBtn = driver.findElement(Locators.SEND_NAME_BUTTON);
        sendBtn.click();
        // Wait for 2 seconds
        commonFunctions.waitForSeconds(2);
        // Assertion: check result text contains "Benz" and "Mercedes"
        WebElement resultText = driver.findElement(Locators.RESULT_TEXT);
        AssertionsHelper.assertTrue(resultText.isDisplayed(), resultText.getText());
        System.out.println(resultText.getText());
    }
}