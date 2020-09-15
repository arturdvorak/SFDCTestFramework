package tests;

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
    String login_url;
    String username;
    String password;

    private WebDriver driver;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Init browser")
    public void setUp() {
        propertiesReader = PropertiesReader.getInstance();

        base_url = propertiesReader.getValue("BASE_URL");
        login_url = propertiesReader.getValue("LOGIN_URL");
        username = propertiesReader.getValue("USERNAME");
        password = propertiesReader.getValue("PASSWORD");

        driver = WebDriverSingleton.getWebDriverInstance();
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);
        accountSteps = new AccountSteps(driver);
    }

    @AfterClass(description = "Closing ChromeDriver")
    public void closeDriver() {
        driver.close();
    }
}
