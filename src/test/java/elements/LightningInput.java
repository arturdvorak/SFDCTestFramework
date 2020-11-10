package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LightningInput extends BaseElement {
    private static final String INPUT_LOCATOR = "//label[text()='%s']/ancestor::lightning-input//input";

    public LightningInput(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInput(String text) {
        WebElement element = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, title)));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        log.atInfo().log("'{}' text is inputted to '{}' field", text, title);
    }
}
