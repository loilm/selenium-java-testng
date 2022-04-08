package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private CommonPage commonPage;

    By userNameTxt = By.id("username");
    By passWordTxt = By.id("password");
    By clickBtn = By.xpath("//button[@type='submit']");
    By message = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void login(String userName, String passWord) {
        commonPage.setText(userNameTxt, userName);
        commonPage.setText(passWordTxt, passWord);
        commonPage.clickElement(clickBtn);
    }

    public void verifyURL(String expectedUrl) {
        Assert.assertEquals(commonPage.getURL(), expectedUrl);
    }

    public void verifyMessage(String expectedMessage) {
        String actualMessage = driver.findElement(message).getText();
        Assert.assertTrue(driver.findElement(message).isDisplayed());
        //remove last character "x" and check
        Assert.assertEquals(actualMessage.substring(0, actualMessage.length() - 1).trim(), expectedMessage);
    }
}
