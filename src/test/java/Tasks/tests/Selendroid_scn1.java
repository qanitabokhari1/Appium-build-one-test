package Tasks.tests;

import Tasks.pages.Selendroid_homePage;
import Tasks.base.Selendroid_Base; // ADD THIS
import Tasks.utils.CommonFunctions;
import org.testng.annotations.Test;

public class Selendroid_scn1 extends Selendroid_Base {  // extend base class

    @Test
    public void testUserRegistration() {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Selendroid_homePage selendroidHomePage = new Selendroid_homePage(driver);
        selendroidHomePage.handlePermissions();
        selendroidHomePage.startUserRegisterration();
        selendroidHomePage.registerNewUser();
        selendroidHomePage.selectCar();
    }
}
