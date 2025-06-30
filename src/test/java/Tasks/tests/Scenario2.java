package Tasks.tests;

import Tasks.base.AppSwitcher;
import Tasks.base.BaseTest;
import Tasks.pages.HomePage;
import Tasks.pages.MultipleChoicePage;
import Tasks.pages.WarpPage;
import Tasks.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Scenario2 extends BaseTest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testScenario2()  {
        HomePage home = new HomePage(driver);
        //      WarpPage wp = new WarpPage(driver);
        MultipleChoicePage multipleChoice = new MultipleChoicePage(driver);
        //for continue click and ok click while app launching
        home.handlePermissions();

        // Select "Multiple-choice mode"
        home.selectMultipleChoiceMode();

        // Select 5 random radio buttons
        multipleChoice.selectRandomRadioButtons(5);

        // Delete all selected items
        multipleChoice.deleteSelectedItems();

        multipleChoice.verifyItemsDeleted();
        // Close the first app
        AppSwitcher appSwitcher = new AppSwitcher(driver);
        appSwitcher.closeFirstApp( "com.mobeta.android.demodslv" );  // example package
        appSwitcher.launchSecondApp("io.appium.android.apis","ApiDemos");
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}