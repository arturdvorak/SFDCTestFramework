package steps;

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

    public AccountSteps createNewAccount(Account account) {
        accountListPage
                .openPage()
                .openNewAccountModal();
        newAccountModal
                .fillOutNewContactModal(account)
                .saveAccount();
        return this;
    }

    public AccountSteps validationOfAccount(Account account) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .validateAccountData(account);
        return this;
    }

    public AccountSteps updateAccount(Account account, Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .updateOpenAccount(account_updated);
        return this;
    }

    public AccountSteps removeAccount(Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account_updated);
        accountViewPage
                .deleteOpenedAccount();
        return this;
    }

}
