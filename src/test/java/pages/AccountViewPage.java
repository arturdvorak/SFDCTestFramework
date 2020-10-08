package pages;

import elements.*;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath(ACTIVE_TAB_LOCATOR + "//a[@data-label='Details']");
    private static final By FIELD_ACCOUNT_NAME_EDIT = By.xpath("//div/span[text()='Account Name']/ancestor::force-record-layout-item//button");
    private static final By TITLE_ACCOUNTS = By.xpath("//li/span[text()='Accounts']");

    public AccountViewPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage updateOpenAccount(Account account) {
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_ACCOUNT_NAME_EDIT).click();
        waitForPageLoaded();
        new LightningInput(driver, "Account Name").fillInput(account.getAccountName());
        new LightningLookUp(driver, "Parent Account").select(account.getParentAccount());
        new LightningInput(driver, "Account Number").fillInput(Integer.toString(account.getAccountNumber()));
        new LightningInput(driver, "Account Site").fillInput(account.getAccountSite());
        new LightningDropDown(driver, "Type").select(account.getType());
        new LightningDropDown(driver, "Industry").select(account.getIndustry());
        new LightningInput(driver, "Annual Revenue").fillInput(Integer.toString(account.getAnnualRevenue()));
        new LightningDropDown(driver, "Rating").select(account.getRating());
        new LightningInput(driver, "Phone").fillInput(account.getPhone());
        new LightningInput(driver, "Fax").fillInput(account.getFax());
        new LightningInput(driver, "Website").fillInput(account.getWebsite());
        new LightningInput(driver, "Ticker Symbol").fillInput(account.getTickerSymbol());
        new LightningDropDown(driver, "Ownership").select(account.getOwnership());
        new LightningInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));
        new LightningInput(driver, "SIC Code").fillInput(Integer.toString(account.getSicCode()));
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
        new LightningDropDown(driver, "Customer Priority").select(account.getCustomerPriority());
        new LightningInput(driver, "Number of Locations").fillInput(Integer.toString(account.getNumberOfLocations()));
        new LightningDropDown(driver, "Active").select(account.getActive());
        new LightningDropDown(driver, "SLA").select(account.getSla());
        new LightningDropDown(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_ACCOUNT_NAME_EDIT));
        return new AccountListPage(driver);
    }

    public AccountListPage validateAccountData(Account account) {
        driver.findElement(TAB_DETAILS).click();
        waitForPageLoaded();
        new ForceRecord(driver, "Account Name").validateFieldValue(account.getAccountName());
        new ForceRecord(driver, "Parent Account").validateFieldValue(account.getParentAccount());
        new ForceRecord(driver, "Account Number").validateFieldValue(String.valueOf(account.getAccountNumber()));
        new ForceRecord(driver, "Account Site").validateFieldValue(account.getAccountSite());
        new ForceRecord(driver, "Type").validateFieldValue(account.getType());
        new ForceRecord(driver, "Industry").validateFieldValue(account.getIndustry());
        new ForceRecord(driver, "Annual Revenue").validateFieldValue("$" + String.format("%,d", account.getAnnualRevenue()));
        new ForceRecord(driver, "Phone").validateFieldValue(account.getPhone());
        new ForceRecord(driver, "Fax").validateFieldValue(account.getFax());
        new ForceRecord(driver, "Website").validateFieldValue(account.getWebsite());
        new ForceRecord(driver, "Ticker Symbol").validateFieldValue(account.getTickerSymbol());
        new ForceRecord(driver, "Ownership").validateFieldValue(account.getOwnership());
        new ForceRecord(driver, "Employees").validateFieldValue(String.valueOf(account.getEmployees()));
        new ForceRecord(driver, "SIC Code").validateFieldValue(String.valueOf(account.getSicCode()));
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
        new ForceRecord(driver, "Customer Priority").validateFieldValue(account.getCustomerPriority());
        new ForceRecord(driver, "Number of Locations").validateFieldValue(String.valueOf(account.getNumberOfLocations()));
        new ForceRecord(driver, "Active").validateFieldValue(account.getActive());
        new ForceRecord(driver, "SLA").validateFieldValue(account.getSla());
        new ForceRecord(driver, "Upsell Opportunity").validateFieldValue(account.getUpsellOpportunity());
        new ForceRecord(driver, "Description").validateFieldValue(account.getDescription());
        return new AccountListPage(driver);
    }

    public AccountListPage deleteOpenedAccount() {
        new Button(driver,"Show 8 more actions").click();
        new Button(driver,"Delete").clickUsingJavaScript();
        driver.switchTo().activeElement();
        new Button(driver,"Delete").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_ACCOUNTS));
        return new AccountListPage(driver);
    }
}
