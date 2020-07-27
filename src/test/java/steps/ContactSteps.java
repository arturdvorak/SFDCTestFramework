package steps;

import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.NewContactModal;

public class ContactSteps {
    ContactListPage contactListPage;
    NewContactModal newContactModal;

    public ContactSteps(WebDriver driver) {
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
    }

    public void createNewContact(String lastName) {
        contactListPage.openPage();
        contactListPage.openNewContactModal();
        newContactModal.fillOutContactDialogAndSave(lastName);
        newContactModal.saveNewContact();
    }
}
