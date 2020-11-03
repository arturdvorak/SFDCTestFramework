package steps;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.AccountViewPage;
import pages.NewAccountModal;

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
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .validateAccountData(account);
        return this;
    }

    @Step("Update account {account.accountName} data to account {account_updated.accountName} data")
    public AccountSteps updateAccount(Account account, Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .updateOpenAccount(account_updated);
        return this;
    }

    @Step("Remove account with name {account_updated.accountName}")
    public AccountSteps removeAccount(Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account_updated);
        accountViewPage
                .deleteOpenedAccount();
        return this;
    }
}
