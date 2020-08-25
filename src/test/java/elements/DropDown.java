package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//*[text() = '%s']/../..//a";
    private static final String DROPDOWN_VALUE = "//a[text()='%s']";

    public DropDown(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInput(String text) {
        System.out.println(String.format("Select '%s' value from '%s' drop-down", text, title));
        WebElement element = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title)));
        element.click();
        element.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))).click();
    }
}
