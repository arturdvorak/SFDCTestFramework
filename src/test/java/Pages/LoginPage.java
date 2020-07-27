package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By USERNAME_CSS = By.id("username");
    private static final By password = By.id("password");
    private static final By login = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage (String url) {
        driver.get(url);
    }

    public HomePage login(String userName, String passwordKeys) {
        driver.findElement(USERNAME_CSS).sendKeys(userName);
        driver.findElement(password).sendKeys(passwordKeys);
        driver.findElement(login).click();
        return new HomePage(driver);
    }
}
