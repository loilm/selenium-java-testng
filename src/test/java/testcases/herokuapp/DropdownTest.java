package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends CommonTest {
    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        dropdownPage = new DropdownPage(driver);
    }

    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/dropdown
     * Select "option 1"
     * Validate "option 1" is selected
     */
    @Test
    public void option1Test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.selectOption1();
    }

    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/dropdown
     * Select "option 2"
     * Validate "option 2" is selected
     */
    @Test
    public void option2Test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.selectOption2();
    }

}
