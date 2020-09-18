package tests;

import com.google.gson.Gson;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;
import utils.PropertiesReader;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {
    PropertiesReader propertiesReader;
    Gson gson;
    public static String base_url;
    String login_url;
    String username;
    String password;
    String cliend_id;
    String client_secret;

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
        cliend_id = propertiesReader.getValue("API.CLIENT.ID");
        client_secret = propertiesReader.getValue("API.CLIENT.SECRET");

        driver = WebDriverSingleton.getWebDriverInstance();
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);
        accountSteps = new AccountSteps(driver);
    }

    protected String getAccessToken(){
        return
                given()
                        .param("client_id", cliend_id)
                        .param("client_secret", client_secret)
                        .param("grant_type", "password")
                        .param("username", username)
                        .param("password", password)
                        .param("Content-type", "application/x-www-form-urlencoded")
                    .when()
                    .post("https://login.salesforce.com/services/oauth2/token")
                    .then()
                        .log().ifError()
                        .statusCode(200)
                        .extract().path("access_token");
        //Response about 'invalid_grant' may be returned in case of incorrect password
    }

    @AfterClass(description = "Closing ChromeDriver")
    public void closeDriver() {
        driver.close();
    }
}
