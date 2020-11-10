package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    public static String browserType;
    public static String loginUrl;
    public static String baseUrl;
    String username;
    String password;
    private WebDriver driver;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp(ITestContext context) {
        loginUrl = PropertyReader.getFromEnvOrFile("LOGIN_URL", "login.url");
        username = PropertyReader.getFromEnvOrFile("USERNAME_SF", "username");
        password = PropertyReader.getFromEnvOrFile("PASSWORD_SF", "password");
        browserType = PropertyReader.getFromEnvOrFile("BROWSER_TYPE", "browser.type");
        baseUrl = PropertyReader.getFromEnvOrFile("BASE_URL_LIGHT", "base.url.light");
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(browserType));
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);
        accountSteps = new AccountSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterClass(description = "Closing browser")
    public void closeDriver() {
        driver.close();
    }
}
