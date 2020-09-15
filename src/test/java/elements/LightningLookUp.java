package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))).size() > 0) {
            WebElement elementRemoveButton = driver.findElement(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title)));
            executor.executeScript("arguments[0].click();", elementRemoveButton);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement lightningLookUp = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        executor.executeScript("arguments[0].click();", lightningLookUp);
        WebElement lightningLookUpValue = driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, title, text)));
        executor.executeScript("arguments[0].click();", lightningLookUpValue);
    }
}
