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
    String username;
    String password;
    private WebDriver driver;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp(ITestContext context) {
        loginUrl = System.getenv().getOrDefault("LOGIN_URL", PropertyReader.getProperty("login.url"));
        log.atInfo().log("'loginUrl' is set to {}", loginUrl);
        username = System.getenv().getOrDefault("USERNAME_SF", PropertyReader.getProperty("username"));
        log.atInfo().log("'Username' is set to {}", username);
        password = System.getenv().getOrDefault("PASSWORD_SF", PropertyReader.getProperty("password"));
        log.atInfo().log("'Password' is set to {}", password);
        browserType = System.getenv().getOrDefault("BROWSER_TYPE", PropertyReader.getProperty("browser.type"));
        log.atInfo().log("'BrowserType' is set to {}", browserType);
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
