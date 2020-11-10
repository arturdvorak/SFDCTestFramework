package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class TextArea extends BaseElement {
    private static final String TEXTAREA_LOCATOR = "//*[text() = '%s']/../..//textarea";

    public TextArea(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInput(String text) {
        log.atInfo().log("'{}' text is inputted to '{}' field", text, title);
        WebElement element = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }
}
