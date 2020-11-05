package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;
import utils.TestListener;

@Listeners(TestListener.class)
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
        loginUrl = System.getenv().getOrDefault("LOGIN_URL", PropertyReader.getProperty("login.url"));
        username = System.getenv().getOrDefault("SF_USERNAME", PropertyReader.getProperty("username"));
        password = System.getenv().getOrDefault("SF_PASSWORD", PropertyReader.getProperty("password"));
        browserType = System.getenv().getOrDefault("BROWSER_TYPE", PropertyReader.getProperty("browser.type"));
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
