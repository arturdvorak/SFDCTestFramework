package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {
    private WebDriver driver;
    private String title;
    private static final String INPUT_LOCATOR = "//label[text()='%s']/..//input";

    public TextInput(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }

    public void fillInput(String text) {
        System.out.println(String.format("Writing '%s' text to field with '%s' label", text, title));
        WebElement element = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }

}
