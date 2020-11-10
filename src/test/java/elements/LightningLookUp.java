package elements;

import driver.JSUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@Log4j2
public class LightningLookUp extends BaseElement {
    private static final String LOCATOR_LOOKUP = "//label[text() = '%s']/ancestor::lightning-lookup";
    private static final String DROPDOWN_LOCATOR = LOCATOR_LOOKUP + "//input";
    private static final String DROPDOWN_REMOVE_BUTTON = LOCATOR_LOOKUP + "//button";
    private static final String DROPDOWN_VALUE = LOCATOR_LOOKUP + "//div[contains(@Class, 'slds-listbox')]//span[text()='%s']";

    public LightningLookUp(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))).size() > 0) {
            log.atInfo().log("The button to remove value from drop-down is found and previously selected value is removed");
            JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))));
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title))));
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, title, text))));
    }
}
