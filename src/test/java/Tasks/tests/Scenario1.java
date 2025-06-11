package Tasks.tests;

import Tasks.base.BaseTest;
import Tasks.pages.HomePage;
import Tasks.pages.WarpPage;
import Tasks.utils.Locators;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest {

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
}
