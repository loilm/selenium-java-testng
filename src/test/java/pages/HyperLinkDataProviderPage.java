package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HyperLinkDataProviderPage {
    private WebDriver driver;
    private CommonPage commonPage;
    By code200 = By.linkText("200");
    By code301 = By.linkText("301");
    By code404 = By.linkText("404");
    By code500 = By.linkText("500");
    By here = By.linkText("here");
    By content = By.id("content");

    public HyperLinkDataProviderPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void clickAndVerify(String name, String expectedContent, String expectedUrl) {
        if (name.trim().equalsIgnoreCase("200")) {
            commonPage.clickElement(code200);
        } else if (name.trim().equalsIgnoreCase("301")) {
            commonPage.clickElement(code301);
        } else if (name.trim().equalsIgnoreCase("404")) {
            commonPage.clickElement(code404);
        } else if (name.trim().equalsIgnoreCase("500")) {
            commonPage.clickElement(code500);
        }
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
        Assert.assertTrue(driver.findElement(content).getText().contains(expectedContent));
        commonPage.clickElement(here);
    }
}
