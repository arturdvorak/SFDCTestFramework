package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {
    private WebDriver driver;
    private String title;
    private String text;
    private static final String TEXTAREA_LOCATOR = "//label[text()='%s']/..//textarea";

    public TextArea(WebDriver driver, String title, String text) {
        this.driver = driver;
        this.title = title;
        this.text = text;
    }

    public void fillTextArea() {
        System.out.println(String.format("Writing text '%s' to the filed with label '%s'", text, title));
        WebElement element = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }
}
