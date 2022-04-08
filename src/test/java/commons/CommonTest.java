package commons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CommonTest {
//    Setting browser and run testcase with .xml file
    @Parameters("browser")
    @BeforeClass
    public void baseSetup(String browserName) {
        Browser.browserSetup(browserName);
    }

//    @BeforeClass
//    public void baseSetup() {
//        Browser.browserSetup("chrome");
//    }

    @AfterClass
    public void tearDown() {
        Browser.getDriver().quit();
    }
}
