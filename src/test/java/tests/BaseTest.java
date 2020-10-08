package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;
import java.io.IOException;

public abstract class BaseTest {
    public static String browserType;
    public static String loginUrl;
    String username;
    String password;
    private WebDriver driver;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp() {
        try {
            loginUrl = PropertyReader.getProperty("login.url");
            username = PropertyReader.getProperty("username");
            password = PropertyReader.getProperty("password");
            browserType = PropertyReader.getProperty("browser.type");
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(browserType));
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);
        accountSteps = new AccountSteps(driver);
    }

    @AfterClass(description = "Closing browser")
    public void closeDriver() {
        driver.close();
    }
}
