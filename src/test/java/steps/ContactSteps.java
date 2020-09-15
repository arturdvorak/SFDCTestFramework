package steps;

import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.ContactViewPage;
import pages.NewContactModal;

public class ContactSteps {
    ContactListPage contactListPage;
    NewContactModal newContactModal;
    ContactViewPage contactViewPage;

    public ContactSteps(WebDriver driver) {
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
        contactViewPage = new ContactViewPage(driver);
    }

    public void createNewContact(Contact contact) {
        contactListPage.openPage();
        contactListPage.openNewContactModal();
        newContactModal.fillOutNewContactModal(contact);
        newContactModal.saveContact();
    }

    public void validationOfContact(Contact contact) {
        contactListPage.openPage();
        contactListPage.openContact(contact);
        contactViewPage.validateContactData(contact);
    }

    public void updateContact(Contact contact, Contact contact_updated) {
        contactListPage.openPage();
        contactListPage.openContact(contact);
        contactViewPage.updateOpenContact(contact_updated);
    }

    public void removeContact(Contact contact) {
        contactListPage.openPage();
        contactListPage.openContact(contact);
        contactViewPage.deleteOpenedContact();
    }
}
