package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Open login page")
    public LoginSteps open() {
        loginPage.openPage();
        return this;
    }

    @Step("Log in to SFDC")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }
}
