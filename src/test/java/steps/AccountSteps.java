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

    @Step
    public AccountSteps createNewAccount(Account account) {
        accountListPage
                .openPage()
                .openNewAccountModal();
        newAccountModal
                .fillOutNewContactModal(account)
                .saveAccount();
        return this;
    }

    @Step
    public AccountSteps validationOfAccount(Account account) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .validateAccountData(account);
        return this;
    }

    @Step
    public AccountSteps updateAccount(Account account, Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .updateOpenAccount(account_updated);
        return this;
    }

    @Step
    public AccountSteps removeAccount(Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account_updated);
        accountViewPage
                .deleteOpenedAccount();
        return this;
    }
}
