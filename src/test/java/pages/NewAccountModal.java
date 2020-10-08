package pages;

import elements.*;
import models.Account;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModal extends BasePage {
    private static final By BANNER_ACCOUNT = By.cssSelector("img[title='Account']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal fillOutNewContactModal(Account account) {
        waitForPageLoaded();
        new SFInput(driver, "Account Name").fillInput(account.getAccountName());
        new SFLookUp(driver, "Parent Account").select(account.getParentAccount());
        new SFInput(driver, "Account Number").fillInput(Integer.toString(account.getAccountNumber()));
        new SFInput(driver, "Account Site").fillInput(account.getAccountSite());
        new SFDropDown(driver, "Type").select(account.getType());
        new SFDropDown(driver, "Industry").select(account.getIndustry());
        new SFInput(driver, "Annual Revenue").fillInput(Integer.toString(account.getAnnualRevenue()));
        new SFDropDown(driver, "Rating").select(account.getRating());
        new SFInput(driver, "Phone").fillInput(account.getPhone());
        new SFInput(driver, "Fax").fillInput(account.getFax());
        new SFInput(driver, "Website").fillInput(account.getWebsite());
        new SFInput(driver, "Ticker Symbol").fillInput(account.getTickerSymbol());
        new SFDropDown(driver, "Ownership").select(account.getOwnership());
        new SFInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));
        new SFInput(driver, "SIC Code").fillInput(Integer.toString(account.getSicCode()));
        new TextArea(driver, "Billing Street").fillInput(account.getBillingStreet());
        new SFInput(driver, "Billing City").fillInput(account.getBillingCity());
        new SFInput(driver, "Billing State/Province").fillInput(account.getBillingState());
        new SFInput(driver, "Billing Zip/Postal Code").fillInput(account.getBillingZip());
        new SFInput(driver, "Billing Country").fillInput(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").fillInput(account.getMailingStreet());
        new SFInput(driver, "Shipping City").fillInput(account.getMailingCity());
        new SFInput(driver, "Shipping State/Province").fillInput(account.getMailingState());
        new SFInput(driver, "Shipping Zip/Postal Code").fillInput(account.getMailingZip());
        new SFInput(driver, "Shipping Country").fillInput(account.getMailingCountry());
        new SFDropDown(driver, "Customer Priority").select(account.getCustomerPriority());
        new SFInput(driver, "Number of Locations").fillInput(Integer.toString(account.getNumberOfLocations()));
        new SFDropDown(driver, "Active").select(account.getActive());
        new SFDropDown(driver, "SLA").select(account.getSla());
        new SFDropDown(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        return this;
    }

    public AccountListPage saveAccount() {
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_ACCOUNT));
        return new AccountListPage(driver);
    }
}
