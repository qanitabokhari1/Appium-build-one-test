package Tasks.tests;

import Tasks.base.BaseTest;
import Tasks.pages.HomePage;
import Tasks.pages.WarpPage;
import Tasks.utils.ExtentReportManager;
import Tasks.utils.Locators;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest {
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testScenario1()  {
        HomePage home = new HomePage(driver);
        WarpPage warpPage = new WarpPage(driver);

        //for continue click and ok click while app launching
        home.handlePermissions();
        home.selectWarpMode();
        warpPage.findNigeria();
        warpPage.dragNigeriaUp();
        warpPage.swipeLeftToDeleteAfghanistan();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
