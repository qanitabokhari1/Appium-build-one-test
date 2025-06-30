package Tasks.tests;

import Tasks.base.Selendroid_Base;
import Tasks.pages.Selendroid_ShowProgressBar;
import Tasks.pages.Selendroid_homePage;
import Tasks.utils.CommonFunctions;
import Tasks.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Selendroid_scn3 extends Selendroid_Base {
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReporter();
    }
    @Test
    public void show_progress_bar(){
        Selendroid_ShowProgressBar showProgressBar = new Selendroid_ShowProgressBar(driver);
        CommonFunctions functions = new CommonFunctions(driver);
        showProgressBar.handlePermissions();
        showProgressBar.clickWaitingButtonAndWaitForLoad();
    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
