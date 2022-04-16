package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NestedFramesPage {
    private WebDriver driver;
    private CommonPage commonPage;
    By bodyContent = By.xpath("//body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void switchFrameAndVerifyContent(String nameFrame, String expectContent) {
        driver.switchTo().frame(nameFrame);
        Assert.assertEquals(commonPage.getText(bodyContent), expectContent);
    }
}
