package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;
import utils.PropertiesReader;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    PropertiesReader propertiesReader;
    public static String baseUrl;
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
        propertiesReader = PropertiesReader.getInstance();
        baseUrl = propertiesReader.getValue("base.url.light");
        loginUrl = propertiesReader.getValue("login.url");
        username = propertiesReader.getValue("username");
        password = propertiesReader.getValue("password");
        browserType = propertiesReader.getValue("browser.type");
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
