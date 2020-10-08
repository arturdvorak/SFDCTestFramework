package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

import java.io.IOException;

public class LoginPage extends BasePage {
    private static final By USERNAME_CSS = By.id("username");
    private static final By INPUT_PASSWORD = By.id("password");
    private static final By INPUT_LOGIN = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage () {
        driver.get(BaseTest.loginUrl);
    }

    public void login(String userName, String passwordKeys) {
        driver.findElement(USERNAME_CSS).sendKeys(userName);
        driver.findElement(INPUT_PASSWORD).sendKeys(passwordKeys);
        driver.findElement(INPUT_LOGIN).click();
    }
}
