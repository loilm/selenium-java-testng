package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends CommonTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void successLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage.login("tomsmith", "SuperSecretPassword!");
        loginPage.verifyURL("https://the-internet.herokuapp.com/secure");
        loginPage.verifyMessage("You logged into a secure area!");
    }

    @Test
    public void invalidUsernameLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage.login("admin", "SuperSecretPassword!");
        loginPage.verifyMessage("Your username is invalid!");
    }

    @Test
    public void invalidPasswordLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage.login("tomsmith", "Super");
        loginPage.verifyMessage("Your password is invalid!");
    }
}
