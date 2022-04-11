package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HyperLinkPage;

public class HyperLinkTest extends CommonTest {
    private WebDriver driver;
    private HyperLinkPage hyperLinkPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        hyperLinkPage = new HyperLinkPage(driver);
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/status_codes
     * Click on "200"
     * Then "200 status code" page appear
     * Click on "go here"
     *
     * Click on "301"
     * Then "301 status code" page appear
     * Click on "go here"
     *
     * Click on "404"
     * Then "404 status code" page appear
     * Click on "go here"
     *
     * Click on "500"
     * Then "500 status code" page appear
     * Click on "go here"
     */
    @Test
    public void linkTest() {
        hyperLinkPage.clickAndVerify200("https://the-internet.herokuapp.com/status_codes/200","This page returned a 200 status code");
        hyperLinkPage.clickAndVerify301("https://the-internet.herokuapp.com/status_codes/301","This page returned a 301 status code");
        hyperLinkPage.clickAndVerify404("https://the-internet.herokuapp.com/status_codes/404","This page returned a 404 status code");
        hyperLinkPage.clickAndVerify500("https://the-internet.herokuapp.com/status_codes/500","This page returned a 500 status code");
    }
}
