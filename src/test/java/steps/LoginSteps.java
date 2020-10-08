package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step
    public LoginSteps open() {
        loginPage.openPage();
        return this;
    }

    @Step
    public void login(String username, String password) {
        loginPage.login(username, password);
    }
}
