package Tasks.tests;

import Tasks.base.Selendroid_Base;
import Tasks.pages.Selendroid_SelectLongPage;

import org.testng.annotations.Test;

public class Selendroid_scn2 extends Selendroid_Base {
    @Test
    public void LongPage_To_FormPage() {
        Selendroid_SelectLongPage formPage = new Selendroid_SelectLongPage(driver);
        formPage.handlePermissions();
        formPage.selectLongContentAndFormPage();

    }
}
