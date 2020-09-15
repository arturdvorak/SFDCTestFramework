package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class ForceRecord extends BaseElement {
    protected final static String FORCE_RECORD_LOCATOR = "//span[text()='%s']/ancestor::force-record-layout-item//";
    private static final String FIELD_LOCATOR = ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "a|" +
                    ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-text|" +
                    ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR+ "lightning-formatted-number|" +
                    ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-address|" +
                    ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-name";
    
    public ForceRecord(WebDriver driver, String title) {
        super(driver, title);
    }

    public void validateFieldValue(String text) {
        System.out.println(String.format("Validating that field with label '%s' contains '%s' text", title, text));
        assertEquals(driver.findElement(By.xpath(String.format(FIELD_LOCATOR, title, title, title, title, title))).getText(), text,
                String.format("'%s' value is saved incorrectly.", title));
    }
}
