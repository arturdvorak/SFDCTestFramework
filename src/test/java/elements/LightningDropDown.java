package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightningDropDown extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//label[text() = '%s']/ancestor::lightning-combobox//input";
    private static final String DROPDOWN_VALUE = "//lightning-base-combobox-item//span[text()='%s']";

    public LightningDropDown(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        System.out.println(String.format("Select '%s' value from '%s' drop-down", text, title));
        WebElement elementDropDown = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", elementDropDown);
        WebElement elementDropDownValue = driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, text)));
        executor.executeScript("arguments[0].click();", elementDropDownValue);
    }
}
