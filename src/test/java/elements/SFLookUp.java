package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class SFLookUp extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//span[text() = '%s']/ancestor::div[contains(@Class,'forceSearchInputLookupDesktop')]//input";
    private static final String DROPDOWN_VALUE = "//div[contains(@Class, 'lookup__menu')]//div[text()='%s']";

    public SFLookUp(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        log.atInfo().log("Select '{}' value from '{}' drop-down", text, title);
        WebElement element = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        element.click();
        element.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))).click();
    }
}
