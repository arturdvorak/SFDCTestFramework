package elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElement {
    protected WebDriver driver;
    protected String title;
    protected WebDriverWait wait;
    protected final static String ACTIVE_TAB_LOCATOR = "//div[contains(@class,'active')]";

    public BaseElement(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        wait = new WebDriverWait(driver, 30);
    }
}
