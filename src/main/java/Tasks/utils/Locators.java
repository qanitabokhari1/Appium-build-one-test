package Tasks.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Locators {

    // Permission buttons
    public static final By CONTINUE_BUTTON = AppiumBy.id("com.android.permissioncontroller:id/continue_button");
    public static final By ALLOW_BUTTON = AppiumBy.id("android:id/button1");

    // Home screen options
    public static final By MULTIPLE_CHOICE_MODE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Multiple-choice mode\")");
    public static final By WARP_MODE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Warp\")");

    // Drag handles
    public static final By DRAG_HANDLE = By.id("com.mobeta.android.demodslv:id/drag_handle");
    public static final By AFGHANISTAN_DRAG_HANDLE = By.xpath("(//android.widget.ImageView[@resource-id='com.mobeta.android.demodslv:id/drag_handle'])[2]");
    public static final By NIGERIA_DRAG_HANDLE = By.xpath("(//android.widget.ImageView[@resource-id='com.mobeta.android.demodslv:id/drag_handle'])[6]");
    public static final By TARGET_DRAG_HANDLE_TOP = By.xpath("(//android.widget.ImageView[@resource-id='com.mobeta.android.demodslv:id/drag_handle'])[1]");

    // Delete button
    public static final By DELETE_ICON = By.xpath("(//android.widget.ImageView[@resource-id='com.mobeta.android.demodslv:id/click_remove'])[1]");

    // ==================== New Locators for Selendroid_SelectLongPage ====================

    // WebView and Spinner
    public static final By BUTTON_START_WEBVIEW = By.id("io.selendroid.testapp:id/buttonStartWebview");
    public static final By SPINNER_TEST_DATA = By.id("io.selendroid.testapp:id/spinner_webdriver_test_data");

    // Page Selections
    public static final By LONG_CONTENT_PAGE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Long Content Page\")");
    public static final By NORMAL_LINK = AppiumBy.androidUIAutomator("new UiSelector().text(\"Normal link\")");
    public static final By FORM_PAGE = AppiumBy.androidUIAutomator("new UiSelector().text(\"formPage\")");

    // Form Inputs
    public static final By EMAIL_INPUT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"email\")");
    public static final By CHECKBOX_CHECKY = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"checky\")");
    public static final By DROPDOWN_ONE = AppiumBy.androidUIAutomator("new UiSelector().text(\"One\").instance(0)");
    public static final By DROPDOWN_ONE_INSTANCE_TWO = AppiumBy.androidUIAutomator("new UiSelector().text(\"One\").instance(1)");
    public static final By DROPDOWN_FOUR = AppiumBy.androidUIAutomator("new UiSelector().text(\"Four\")");

    public static final By MULTI_SELECT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"multi\")");
    public static final By SELECT_HAM = AppiumBy.androidUIAutomator("new UiSelector().text(\"Ham\")");
    public static final By OK_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")");

    public static final By ZERO_SELECTED_0 = AppiumBy.androidUIAutomator("new UiSelector().text(\"0 selected\").instance(0)");
    public static final By ZERO_SELECTED_1 = AppiumBy.androidUIAutomator("new UiSelector().text(\"0 selected\").instance(1)");
    public static final By SELECT_1 = AppiumBy.androidUIAutomator("new UiSelector().text(\"select_1\")");

    public static final By EMPTY_CLICK_VIEW = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(20)");
    public static final By DROPDOWN_TEXT1 = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\").instance(0)");

    public static final By CHECKBOX_CHEESE = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cheese\")");

    public static final By WORKING_INPUT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"working\")");
    public static final By WITH_TEXT_INPUT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"withText\")");
    public static final By EMPTY_TEXT_AREA = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"emptyTextArea\")");
    public static final By INPUT_WITH_TEXT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"inputWithText\")");
    public static final By IMAGE_FIELD = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"no-type\")");
    public static final By UPLOAD_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"upload\")");
    public static final By REDIRECT_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"redirect\")");
    public static final By SELECT_ONE = AppiumBy.androidUIAutomator("new UiSelector().text(\"One\")");
    public static final By CHECKBOX_WITH_LABEL = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"checkbox-with-label\")");

    public static final By NAME_INPUT = By.xpath("(//android.widget.EditText[@text=\"name\"])[1]");
    public static final By ID_NAME1 = By.xpath("//android.widget.EditText[@resource-id=\"id-name1\"]");
    public static final By ID_NAME2 = By.xpath("//android.widget.EditText[@resource-id=\"id-name2\"]");
    public static final By NAME_INPUT_TWO = By.xpath("(//android.widget.EditText[@text=\"name\"])[2]");

    public static final By SEARCH_GADGET = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"vsearchGadget\")");
    public static final By SUBMIT_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"Submit\").instance(0)");

    // ========== Selendroid Home Page Locators ==========

    public static final By SELENDROID_CONTINUE = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/continue_button\")");
    public static final By SELENDROID_OK = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")");
    public static final By START_USER_REGISTRATION = AppiumBy.accessibilityId("startUserRegistrationCD");
    public static final By INPUT_USERNAME = By.id("io.selendroid.testapp:id/inputUsername");
    public static final By INPUT_EMAIL = By.id("io.selendroid.testapp:id/inputEmail");
    public static final By INPUT_PASSWORD = By.id("io.selendroid.testapp:id/inputPassword");
    public static final By INPUT_NAME = By.id("io.selendroid.testapp:id/inputName");

    public static final By SCROLL_TO_REGISTER_BUTTON = AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                    "new UiSelector().resourceId(\"io.selendroid.testapp:id/btnRegisterUser\"))");

    public static final By PREFERRED_PROGRAMMING_LANGUAGE_DROPDOWN = By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
    public static final By PREFERRED_LANGUAGE_PHP = AppiumBy.androidUIAutomator("new UiSelector().text(\"PHP\")");

    public static final By INPUT_ADDS_CHECKBOX = By.id("io.selendroid.testapp:id/input_adds");

    public static final By BTN_REGISTER_USER = By.id("io.selendroid.testapp:id/btnRegisterUser");
    public static final By BUTTON_REGISTER_USER = By.id("io.selendroid.testapp:id/buttonRegisterUser");

// Already exist: BUTTON_START_WEBVIEW
// Already exist: SPINNER_TEST_DATA

    public static final By SAY_HELLO_DEMO_OPTION = By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"'Say Hello'-Demo\"]");
    public static final By NAME_INPUT_WEBVIEW = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"name_input\")");

    public static final By SELECT_VOLVO = AppiumBy.androidUIAutomator("new UiSelector().text(\"Volvo\")");
    public static final By SELECT_MERCEDES = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Mercedes\"]");

    public static final By SEND_NAME_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me your name!\")");
    public static final By RESULT_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Hello !\")");

    // ============ Upload Image by URL ============

    // Upload button

    // Submit/Upload button (adjust if needed)

//    public static final By PAGE_HEADER = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"header\")");
//    public static final By UPLOADED_IMAGE_LABEL = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"uploadedImage\")");
//    public static final By SUBMIT_SUCCESS_MSG = AppiumBy.androidUIAutomator("new UiSelector().text(\"Form submitted successfully!\")");

    //======================= Scnerio 3 Locators ==========================
    public static final By SHOW_PROGRESS_BAR = AppiumBy.id("io.selendroid.testapp:id/waitingButtonTest");
    public static final By TOAST_BAR = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/showToastButton\")");
    public static final By DISPLAY_WINDOW_POPUP = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/showPopupWindowButton\")");
    public static final By DISMISS = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/exceptionTestField\")");
    public static final By FOCUS  = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/topLevelElementTest\")");

    //=========================== task 4 Locators =========================
    public static final By SWIPE_4 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Swipe\")");
    public static final By COMPATIBLE = AppiumBy.androidUIAutomator("new UiSelector().text(\"COMPATIBLE\")");
    public static final By FULLY_OPEN_SOURCE = AppiumBy.androidUIAutomator("new UiSelector().text(\"FULLY OPEN SOURCE\")");

    //=========================== task 4 Locators S2=========================
    public static final By DRAG_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag\")");

}
