package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Open login page")
    public LoginSteps open() {
        log.atInfo().log("Open login page");
        loginPage.openPage();
        return this;
    }

    @Step("Log in to SFDC")
    public void login(String username, String password) {
        log.atInfo().log("Log in to SFDC using {} and {}", username, password);
        loginPage.login(username, password);
    }
}
