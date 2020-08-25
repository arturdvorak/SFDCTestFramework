package steps;

import org.openqa.selenium.WebDriver;
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
