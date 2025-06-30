package Tasks.tests;

import Tasks.pages.Selendroid_homePage;
import Tasks.base.Selendroid_Base; // ADD THIS
import Tasks.utils.CommonFunctions;
import Tasks.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Selendroid_scn1 extends Selendroid_Base {  // extend base class

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReporter();
    }

    @Test
    public void testUserRegistration() {
        Selendroid_homePage selendroidHomePage = new Selendroid_homePage(driver);
        selendroidHomePage.handlePermissions();
        selendroidHomePage.startUserRegisterration();
        selendroidHomePage.registerNewUser();
        selendroidHomePage.selectCar();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
