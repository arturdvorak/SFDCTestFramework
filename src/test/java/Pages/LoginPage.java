package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By username = By.cssSelector("#username");
    By password = By.cssSelector("#password");
    By login = By.cssSelector("#Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage (String url) {
        driver.get(url);
    }

    public HomePage login(String userName, String passwordKeys) {
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(passwordKeys);
        driver.findElement(login).click();
        return new HomePage(driver);
    }
}
