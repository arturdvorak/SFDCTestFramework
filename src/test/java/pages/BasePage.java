package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    PropertiesReader propertiesReader;
    String base_url;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        propertiesReader = PropertiesReader.getInstance();
        base_url = propertiesReader.getValue("BASE_URL");
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
