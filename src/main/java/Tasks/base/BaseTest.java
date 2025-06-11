package Tasks.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    // AndroidDriver is used to interact with the Android device via Appium
    public AndroidDriver driver;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Appium server URL (replace with actual server if needed)
        String appiumServerUrl = "http://127.0.0.1:4723/";
        // DesiredCapabilities is used to specify the properties for the Appium session
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        // Setting platform name to Android
        capabilities.setCapability("platformName", "Android");
        // Using UiAutomator2 for Android automation
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        // Setting the app's package (Appium will open this app)
        capabilities.setCapability("appium:appPackage", "com.mobeta.android.demodslv");
        // Setting the app's activity (Appium will open this app)
        capabilities.setCapability("appium:appActivity", ".Launcher");
        // Initializing the AndroidDriver with the specified capabilities
        driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        // Check if the driver is not null, and if so, quit the session
        if (driver != null) {
            driver.quit();
        }
    }
}
