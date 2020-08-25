package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownWithSearchByLabel extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//label[text() = '%s']/../..//input";
    private static final String DROPDOWN_REMOVE_BUTTON = DROPDOWN_LOCATOR + "/..//button";
    private static final String DROPDOWN_VALUE = "//span[text()='%s']";

    public DropDownWithSearchByLabel(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInput(String text) {
        System.out.println(String.format("Select '%s' value from '%s' drop-down", text, title));
        driver.findElement(By.xpath(String.format(DROPDOWN_REMOVE_BUTTON, title))).click();
        WebElement element = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        element.click();
        element.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))).click();
    }
}
