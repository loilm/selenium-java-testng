package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    private static WebDriver driver;

    public static WebDriver browserSetup(String browserName) {
        if (browserName.trim().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.trim().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.trim().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
