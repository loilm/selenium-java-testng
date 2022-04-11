package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HyperLinkPage {
    private WebDriver driver;
    private CommonPage commonPage;
    By code200 = By.linkText("200");
    By code301 = By.linkText("301");
    By code404 = By.linkText("404");
    By code500 = By.linkText("500");
    By linkHere = By.linkText("here");
    By content = By.id("content");

    public HyperLinkPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void clickAndVerify200(String expectedUrl, String contentTxt) {
        commonPage.clickElement(code200);
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
        Assert.assertTrue(driver.findElement(content).getText().contains(contentTxt));
        commonPage.clickElement(linkHere);
    }

    public void clickAndVerify301(String expectedUrl, String contentTxt) {
        commonPage.clickElement(code301);
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
        Assert.assertTrue(driver.findElement(content).getText().contains(contentTxt));
        commonPage.clickElement(linkHere);
    }

    public void clickAndVerify404(String expectedUrl, String contentTxt) {
        commonPage.clickElement(code404);
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
        Assert.assertTrue(driver.findElement(content).getText().contains(contentTxt));
        commonPage.clickElement(linkHere);
    }

    public void clickAndVerify500(String expectedUrl, String contentTxt) {
        commonPage.clickElement(code500);
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
        Assert.assertTrue(driver.findElement(content).getText().contains(contentTxt));
        commonPage.clickElement(linkHere);
    }

}
