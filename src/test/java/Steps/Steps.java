package Steps;

import Driver.WebDriverSingleton;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver driver;

    public Steps() {
        WebDriver newInstanceOfDriver = WebDriverSingleton.getWebDriverInstance();
        this.driver = newInstanceOfDriver;
    }

    public void closeDriver() {
        driver.quit();
    }

    public void openStartPage(String url) {
        driver.get(url);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void loginToSFDC(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(username, password);
    }
}
