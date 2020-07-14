package Pages;

import Driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BasePage {
    LoginPage loginPage;
    HomePage homePage;
    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = WebDriverSingleton.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(description = "Closing ChromeDriver", alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
