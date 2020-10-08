package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;
import java.io.IOException;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final static String ACTIVE_TAB_LOCATOR = "//div[contains(@class,'active')]";
    protected String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        try {
            baseUrl = PropertyReader.getProperty("base.url.light");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

}
