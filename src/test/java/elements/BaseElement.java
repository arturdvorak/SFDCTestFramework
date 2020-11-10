package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
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
