package pages;

import elements.*;
import models.Account;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModal extends BasePage {
    private static final By BANNER_ACCOUNT = By.cssSelector("img[title='Account']");
    private static final By BUTTON_SAVE = By.cssSelector("button[title='Save']");
    private static final By INPUT_ACCOUNT_NAME = By.xpath("//label/span[text()='Account Name']/../..//input");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void fillOutNewContactModal(Account account) {
        driver.findElement(INPUT_ACCOUNT_NAME).sendKeys(account.getAccountName());

        new DropDownWithSearch(driver, "Parent Account").fillInput(account.getParentAccount());
        new DropDown(driver, "Type").fillInput(account.getType());
        new DropDown(driver, "Industry").fillInput(account.getIndustry());

        new TextInput(driver, "Website").fillInput(account.getWebsite());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        new TextInput(driver, "Phone").fillInput(account.getPhone());
        new TextInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));

        new TextArea(driver, "Billing Street").fillInput(account.getBillingStreet());
        new TextInput(driver, "Billing City").fillInput(account.getBillingCity());
        new TextInput(driver, "Billing State/Province").fillInput(account.getBillingState());
        new TextInput(driver, "Billing Zip/Postal Code").fillInput(account.getBillingZip());
        new TextInput(driver, "Billing Country").fillInput(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").fillInput(account.getMailingStreet());
        new TextInput(driver, "Shipping City").fillInput(account.getMailingCity());
        new TextInput(driver, "Shipping State/Province").fillInput(account.getMailingState());
        new TextInput(driver, "Shipping Zip/Postal Code").fillInput(account.getMailingZip());
        new TextInput(driver, "Shipping Country").fillInput(account.getMailingCountry());
    }

    public void saveAccount() {
        driver.findElement(BUTTON_SAVE).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_ACCOUNT));
    }
}
