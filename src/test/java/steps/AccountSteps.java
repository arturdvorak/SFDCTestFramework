package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.AccountViewPage;
import pages.NewAccountModal;

@Log4j2
public class AccountSteps {
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;
    AccountViewPage accountViewPage;

    public AccountSteps(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
        accountViewPage = new AccountViewPage(driver);
    }

    @Step(value = "Create new account with name {account.accountName}")
    public AccountSteps createNewAccount(Account account) {
        log.atInfo().log("Create new account with name {}", account.getAccountName());
        accountListPage
                .openPage()
                .openNewAccountModal();
        newAccountModal
                .fillOutNewContactModal(account)
                .saveAccount();
        return this;
    }

    @Step("Validate account with name {account.accountName}")
    public AccountSteps validationOfAccount(Account account) {
        log.atInfo().log("Validate account with name {}", account.getAccountName());
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .validateAccountData(account);
        return this;
    }

    @Step("Update account {account.accountName} data to account {account_updated.accountName} data")
    public AccountSteps updateAccount(Account account, Account account_updated) {
        log.atInfo().log("Update account {} data to account {} data", account.getAccountName(), account_updated.getAccountName());
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .updateOpenAccount(account_updated);
        return this;
    }

    @Step("Remove account with name {account_updated.accountName}")
    public AccountSteps removeAccount(Account account_updated) {
        log.atInfo().log("Remove account with name {}", account_updated.getAccountName());
        accountListPage
                .openPage();
        accountViewPage
                .deleteAccountByName(account_updated);
        return this;
    }
}
