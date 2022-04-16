package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HyperLinkDataProviderPage;

public class HyperLinkDataProviderTest extends CommonTest {
    private WebDriver driver;
    private HyperLinkDataProviderPage dataProviderPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        dataProviderPage = new HyperLinkDataProviderPage(driver);
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    @DataProvider
    Object[][] testdata() {
        return new Object[][]{
                new Object[]{"200", "This page returned a 200 status code.", "https://the-internet.herokuapp.com/status_codes/200"},
                new Object[]{"301", "This page returned a 301 status code.", "https://the-internet.herokuapp.com/status_codes/301"},
                new Object[]{"404", "This page returned a 404 status code.", "https://the-internet.herokuapp.com/status_codes/404"},
                new Object[]{"500", "This page returned a 500 status code.", "https://the-internet.herokuapp.com/status_codes/500"},
        };
    }

    @Test(dataProvider = "testdata")
    public void clickLinkAndVerify(String name, String expectedContent, String expectedUrl) {
        dataProviderPage.clickAndVerify(name, expectedContent, expectedUrl);
    }


}
