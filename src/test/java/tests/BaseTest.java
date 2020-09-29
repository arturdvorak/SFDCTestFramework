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
    public static String base_url;
    public static String browserType;
    String login_url;
    String username;
    String password;
    private WebDriver driver;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp() {
        propertiesReader = PropertiesReader.getInstance();
        base_url = propertiesReader.getValue("BASE_URL");
        login_url = propertiesReader.getValue("LOGIN_URL");
        username = propertiesReader.getValue("USERNAME");
        password = propertiesReader.getValue("PASSWORD");
        browserType = propertiesReader.getValue("BROWSER_TYPE");
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
