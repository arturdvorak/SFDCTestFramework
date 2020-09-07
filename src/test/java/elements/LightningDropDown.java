package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LightningDropDown extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//label[text() = '%s']/ancestor::lightning-combobox//input";
    private static final String DROPDOWN_VALUE = "//lightning-base-combobox-item//span[text()='%s']";

    public LightningDropDown(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        System.out.println(String.format("Select '%s' value from '%s' drop-down", text, title));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DROPDOWN_LOCATOR, title))));
        WebElement element = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        element.click();
        element.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))).click();
    }
}
