package steps;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class AccountSteps {
    private WebDriver driver;

    public AccountSteps() {
        WebDriver newInstanceOfDriver = WebDriverSingleton.getWebDriverInstance();
        this.driver = newInstanceOfDriver;
    }

    void create() {}
    void read() {}
    void update() {}
    void delete() {}
}
