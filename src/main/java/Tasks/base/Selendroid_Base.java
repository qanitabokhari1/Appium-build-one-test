package Tasks.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Selendroid_Base {

    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); // platformName no change
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appium:appActivity", "io.selendroid.testapp.HomeScreenActivity");

        driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
