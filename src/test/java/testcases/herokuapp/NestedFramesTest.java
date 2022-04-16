package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

public class NestedFramesTest extends CommonTest {
    private WebDriver driver;
    private NestedFramesPage nestedFramesPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        nestedFramesPage = new NestedFramesPage(driver);
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test(priority = 0)
    public void leftFrameTest() {
        driver.switchTo().frame("frame-top");
        nestedFramesPage.switchFrameAndVerifyContent("frame-left", "LEFT");
        //       switch frame-top
        driver.switchTo().parentFrame();
    }

    @Test(priority = 1)
    public void middleFrameTest() {
        nestedFramesPage.switchFrameAndVerifyContent("frame-middle", "MIDDLE");
        //       switch frame-top
        driver.switchTo().parentFrame();
    }

    @Test(priority = 2)
    public void rightFrameTest() {
        nestedFramesPage.switchFrameAndVerifyContent("frame-right", "RIGHT");
        //       switch frame-top
        driver.switchTo().parentFrame();
    }

    @Test(priority = 3)
    public void bottomFrameTest() {
        //       switch frame-bottom
        driver.switchTo().parentFrame();
        nestedFramesPage.switchFrameAndVerifyContent("frame-bottom", "BOTTOM");
    }
}
