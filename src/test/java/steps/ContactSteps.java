package steps;

import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.ContactPage;
import pages.NewContactModal;

public class ContactSteps {
    ContactListPage contactListPage;
    NewContactModal newContactModal;
    ContactPage contactPage;

    public ContactSteps(WebDriver driver) {
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
        contactPage = new ContactPage(driver);
    }

    public void createNewContact(Contact contact) {
        contactListPage.openPage();
        contactListPage.openNewContactModal();
        newContactModal.fillOutContactDialogAndSave(contact);
        newContactModal.saveNewContact();
    }

    public void removeAccount(String nameContact) {
        contactListPage.openPage();
        contactListPage.openContactByLastName(nameContact);
        contactPage.deleteOpenedContact();
    }
}
