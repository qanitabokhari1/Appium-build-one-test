package Tasks.base;

import Tasks.utils.CommonFunctions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import Tasks.utils.AssertionsHelper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AppSwitcher {

    private AndroidDriver driver;
    CommonFunctions commonFunctions = new CommonFunctions(driver);
    public AppSwitcher(AndroidDriver driver) {
        this.driver = driver;
    }


    public void closeFirstApp(String firstAppPackage) {
        if (driver.isAppInstalled(firstAppPackage)) {
            driver.terminateApp(firstAppPackage);
            System.out.println("✔ First App (" + firstAppPackage + ") Closed");
            AssertionsHelper.assertTrue(true, "✔ App " + firstAppPackage + " terminated successfully.");
        } else {
            String message = "⚠ App " + firstAppPackage + " is not installed.";
            System.out.println(message);
            AssertionsHelper.fail(message);
        }
    }

    public void launchSecondApp(String secondAppPackage, String secondAppActivity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", secondAppPackage);
        capabilities.setCapability("appium:appActivity", secondAppActivity);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);

            // Wait explicitly for a known element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Replace with actual unique element from your second app

            boolean isInstalled = driver.isAppInstalled(secondAppPackage);
            System.out.println("✔ Second App (" + secondAppPackage + ") Launched Successfully");
            AssertionsHelper.assertTrue(isInstalled, "✔ App " + secondAppPackage + " launched and is installed.");
        } catch (MalformedURLException e) {
            String errorMsg = "❌ Invalid Appium Server URL: " + e.getMessage();
            System.out.println(errorMsg);
            AssertionsHelper.fail(errorMsg);
        } catch (Exception e) {
            String errorMsg = "❌ Error launching app: " + e.getMessage();
            System.out.println(errorMsg);
            AssertionsHelper.fail(errorMsg);
        }

        commonFunctions.waitForSeconds(3);
    }
    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
