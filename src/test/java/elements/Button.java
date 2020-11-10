package elements;

import driver.JSUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

@Log4j2
public class Button extends BaseElement {
    private static final String BUTTON_LOCATOR = "//button[@title='%s']|//div[@title='%s']|//div/a[@title='%s']";
    private static final String MODAL_LOCATOR = "//div[contains(@class,'modal-container')]";
    private static final String BUTTON_LOCATOR_IN_MODAL_LOCATOR = "//button[@title='%s']";

    public Button(WebDriver driver, String title) {
        super(driver, title);
    }

    public void click() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(MODAL_LOCATOR)).size() > 0) {
            log.atInfo().log("Click '{}' button in modal.", title);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title))).click();
        } else {
            log.atInfo().log("Click '{}' button.", title);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR, title, title, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title))).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickUsingJavaScript() {
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title))));
    }
}
