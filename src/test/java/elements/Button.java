package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Button extends BaseElement {
    private static final String BUTTON_LOCATOR = "//button[@title='%s']|//div[@title='%s']|//div/a[@title='%s']";
    private static final String MODAL_LOCATOR = "//div[contains(@class,'modal-container')]";
    private static final String BUTTON_LOCATOR_IN_MODAL_LOCATOR = "//button[@title='%s']";

    public Button(WebDriver driver, String title) {
        super(driver, title);
    }

    public void click() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(String.format(MODAL_LOCATOR))).size() > 0) {
            System.out.println(String.format("Click '%s' button in modal.", title));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title))).click();
        } else {
            System.out.println(String.format("Click '%s' button.", title));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR, title, title, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title))).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickUsingJavaScript() {
        System.out.println(String.format("Click '%s' button.", title));
        WebElement deleteButtonInDropDown = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", deleteButtonInDropDown);
    }
}
