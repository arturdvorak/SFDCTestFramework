package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class JSUtils {
    public static void clickUsingJavaScript(WebDriver driver, WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
}
