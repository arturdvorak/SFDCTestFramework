package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class TextFieldAsLink extends BaseElement {
    private static final String FIELD_LOCATOR = "//span[text()='%s']/../../div[2]//a";

    public TextFieldAsLink(WebDriver driver, String title) {
        super(driver, title);
    }

    public void validateFieldValue(String text) {
        System.out.println(String.format("Validating that field with label '%s' contains '%s' text", title, text));
        assertEquals(driver.findElement(By.xpath(String.format(FIELD_LOCATOR, title))).getText(), text,
                String.format("'%s' value is saved incorrectly.", title));
    }
}
