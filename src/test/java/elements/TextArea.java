package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {
    private WebDriver driver;
    private String title;
    private static final String TEXTAREA_LOCATOR = "//label[text()='%s']/..//textarea";

    public TextArea(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }

    public void fillTextArea(String text) {
        System.out.println(String.format("Writing '%s' text to field with '%s' label", text, title));
        WebElement element = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }
}
