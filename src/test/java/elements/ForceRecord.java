package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ForceRecord extends BaseElement {
    private static final String FIELD_LOCATOR =
            "//span[text()='%s']/ancestor::force-record-layout-item//a|//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";

    public ForceRecord(WebDriver driver, String title) {
        super(driver, title);
    }

    public void validateFieldValue(String text) {
        System.out.println(String.format("Validating that field with label '%s' contains '%s' text", title, text));
        assertEquals(driver.findElement(By.xpath(String.format(FIELD_LOCATOR, title, title))).getText(), text,
                String.format("'%s' value is saved incorrectly.", title));
    }
}
