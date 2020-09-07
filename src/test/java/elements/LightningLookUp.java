package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class LightningLookUp extends BaseElement {
    private static final String LOCATOR_LOOKUP = "//label[text() = '%s']/ancestor::lightning-lookup";
    private static final String DROPDOWN_LOCATOR = LOCATOR_LOOKUP + "//input";
    private static final String DROPDOWN_REMOVE_BUTTON = LOCATOR_LOOKUP + "//button";
    private static final String DROPDOWN_VALUE = LOCATOR_LOOKUP + "//div[contains(@Class, 'slds-listbox')]//span[text()='%s']";

    public LightningLookUp(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        System.out.println(String.format("Select '%s' value from '%s' drop-down", text, title));
        if (driver.findElement(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))) != null) {
            driver.findElement(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))).click();
        }
        WebElement lightningLookUp = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        lightningLookUp.click();
        lightningLookUp.findElement(By.xpath(String.format(DROPDOWN_VALUE, title, text))).click();
    }
}
