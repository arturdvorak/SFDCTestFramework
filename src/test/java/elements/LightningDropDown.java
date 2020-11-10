package elements;

import driver.JSUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LightningDropDown extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//label[text() = '%s']/ancestor::lightning-combobox//input";
    private static final String DROPDOWN_VALUE = "//lightning-base-combobox-item//span[text()='%s']";

    public LightningDropDown(WebDriver driver, String title) {
        super(driver, title);
    }

    public void select(String text) {
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title))));
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))));
        //log.atInfo().log("Select '{}' value from '{}' drop-down", text, title);
    }
}
