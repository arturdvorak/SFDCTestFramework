package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private WebElement username;
    private WebElement pw;

    @FindBy(name = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage (String url) {
        getDriver().get(url);
    }

    public HomePage login(String userName, String passwordKeys) {
        username.sendKeys(userName);
        pw.sendKeys(passwordKeys);
        loginButton.click();
        return new HomePage(driver);
    }
}
