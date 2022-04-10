package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends CommonTest {
    private WebDriver driver;
    private CheckboxesPage checkboxesPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        checkboxesPage = new CheckboxesPage(driver);
    }

    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/checkboxes
     * Check on "checkbox1"
     * Verify "checkbox1" is checked
     * Check on "checkbox2"
     * Verify "checkbox2" is un checked
     */
    @Test
    public void checkbox1Test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxesPage.checkOnCheckbox1AndVerify();
    }

    @Test
    public void checkbox2Test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxesPage.checkOnCheckbox2AndVerify();
    }
}
