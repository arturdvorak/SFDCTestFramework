package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void open(String url) {
        loginPage.openPage(url);
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }
}
