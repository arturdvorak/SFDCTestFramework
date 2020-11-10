package driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

@Log4j2
public class JSUtils {
    public static void clickUsingJavaScript(WebDriver driver, WebElement webElement) {
        log.atInfo().log("Click using JavaScript on element '{}' ", webElement.toString());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
}
