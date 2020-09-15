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

    public void fillOutNewContactModal(Account account) {
        waitForPageLoaded();
        new SFInput(driver, "Account Name").fillInput(account.getAccountName());
        new SFLookUp(driver, "Parent Account").select(account.getParentAccount());
        new SFDropDown(driver, "Type").select(account.getType());
        new SFDropDown(driver, "Industry").select(account.getIndustry());
        new SFInput(driver, "Website").fillInput(account.getWebsite());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        new SFInput(driver, "Phone").fillInput(account.getPhone());
        new SFInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));
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
    }

    public void saveAccount() {
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_ACCOUNT));
    }
}
