package Tasks.tests;

import Tasks.base.Selendroid_Base;
import Tasks.pages.Selendroid_ShowProgressBar;
import Tasks.pages.Selendroid_homePage;
import Tasks.utils.CommonFunctions;
import org.testng.annotations.Test;

public class Selendroid_scn3 extends Selendroid_Base {
    @Test
    public void show_progress_bar(){
        Selendroid_ShowProgressBar showProgressBar = new Selendroid_ShowProgressBar(driver);
        CommonFunctions functions = new CommonFunctions(driver);
        showProgressBar.handlePermissions();
        showProgressBar.clickWaitingButtonAndWaitForLoad();
    }
}
