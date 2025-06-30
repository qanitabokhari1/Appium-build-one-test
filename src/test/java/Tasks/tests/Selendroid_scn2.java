package Tasks.tests;

import Tasks.base.Selendroid_Base;
import Tasks.pages.Selendroid_SelectLongPage;

import Tasks.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Selendroid_scn2 extends Selendroid_Base {
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReporter();
    }
    @Test
    public void LongPage_To_FormPage() {
        Selendroid_SelectLongPage formPage = new Selendroid_SelectLongPage(driver);
        formPage.handlePermissions();
        formPage.selectLongContentAndFormPage();

    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
