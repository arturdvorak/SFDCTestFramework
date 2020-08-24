package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {
    private WebDriver driver;
    private String title;
    private String text;
    private static final String INPUT_LOCATOR = "//label[text()='%s']/..//input";

    public TextInput(WebDriver driver, String title, String text) {
        this.driver = driver;
        this.title = title;
        this.text = text;
    }

    public void fillInput() {
        System.out.println(String.format("Writing text '%s' to the filed with label '%s'", text, title));
        WebElement element = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }

}
