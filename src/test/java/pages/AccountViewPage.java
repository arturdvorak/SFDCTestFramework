package pages;

import elements.*;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath(ACTIVE_TAB_LOCATOR + "//a[@data-label='Details']");
    private static final By FIELD_ACCOUNT_NAME_EDIT = By.xpath("//div/span[text()='Name']/ancestor::force-record-layout-item//button");
    private static final By TITLE_ACCOUNTS = By.xpath("//li/span[text()='Accounts']");

    public AccountViewPage(WebDriver driver) {
        super(driver);
    }

    public void updateOpenAccount(Account account) {
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_ACCOUNT_NAME_EDIT).click();
        waitForPageLoaded();
        new LightningInput(driver, "Account Name").fillInput(account.getAccountName());
        new LightningDropDown(driver, "Type").select(account.getType());
        new LightningInput(driver, "Website").fillInput(account.getWebsite());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        new LightningLookUp(driver, "Parent Account").select(account.getParentAccount());
        new LightningInput(driver, "Phone").fillInput(account.getPhone());
        new LightningDropDown(driver, "Industry").select(account.getIndustry());
        new LightningInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));
        new TextArea(driver, "Billing Street").fillInput(account.getBillingStreet());
        new LightningInput(driver, "Billing City").fillInput(account.getBillingCity());
        new LightningInput(driver, "Billing State/Province").fillInput(account.getBillingState());
        new LightningInput(driver, "Billing Zip/Postal Code").fillInput(account.getBillingZip());
        new LightningInput(driver, "Billing Country").fillInput(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").fillInput(account.getMailingStreet());
        new LightningInput(driver, "Shipping City").fillInput(account.getMailingCity());
        new LightningInput(driver, "Shipping State/Province").fillInput(account.getMailingState());
        new LightningInput(driver, "Shipping Zip/Postal Code").fillInput(account.getMailingZip());
        new LightningInput(driver, "Shipping Country").fillInput(account.getMailingCountry());
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_ACCOUNT_NAME_EDIT));
    }

    public void validateAccountData(Account account) {
        driver.findElement(TAB_DETAILS).click();
        waitForPageLoaded();
        new ForceRecord(driver, "Account Name").validateFieldValue(account.getAccountName());
        new ForceRecord(driver, "Type").validateFieldValue(account.getType());
        new ForceRecord(driver, "Website").validateFieldValue(account.getWebsite());
        new ForceRecord(driver, "Description").validateFieldValue(account.getDescription());
        new ForceRecord(driver, "Parent Account").validateFieldValue(account.getParentAccount());
        new ForceRecord(driver, "Phone").validateFieldValue(account.getPhone());
        new ForceRecord(driver, "Industry").validateFieldValue(account.getIndustry());
        new ForceRecord(driver, "Employees").validateFieldValue(String.valueOf(account.getEmployees()));
        new ForceRecord(driver, "Billing Address").validateFieldValue(
                account.getBillingStreet() + "\n"
                        + account.getBillingCity() + ", "
                        + account.getBillingState() + " "
                        + account.getBillingZip() + "\n"
                        + account.getBillingCountry());
        new ForceRecord(driver, "Shipping Address").validateFieldValue(
                account.getMailingStreet() + "\n"
                        + account.getMailingCity() + ", "
                        + account.getMailingState() + " "
                        + account.getMailingZip() + "\n"
                        + account.getMailingCountry());
    }

    public void deleteOpenedAccount(){
        new Button(driver,"Delete").click();
        driver.switchTo().activeElement();
        new Button(driver,"Delete").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_ACCOUNTS));
    }
}
