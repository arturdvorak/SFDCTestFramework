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
    public void setUp(ITestContext context) {
        loginUrl = System.getenv().getOrDefault("LOGIN_URL", PropertyReader.getProperty("login.url"));
        username = System.getenv().getOrDefault("USERNAME_SF", PropertyReader.getProperty("username"));
        password = System.getenv().getOrDefault("PASSWORD_SF", PropertyReader.getProperty("password"));
        browserType = System.getenv().getOrDefault("BROWSER_TYPE", PropertyReader.getProperty("browser.type"));
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(browserType));
        loginSteps = new LoginSteps(driver);
        context.setAttribute("driver", driver);
        contactSteps = new ContactSteps(driver);
        context.setAttribute("driver", driver);
        accountSteps = new AccountSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterClass(description = "Closing browser")
    public void closeDriver() {
        driver.close();
    }
}
