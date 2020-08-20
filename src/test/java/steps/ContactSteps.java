package steps;

import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.ContactPage;
import pages.ContactViewPage;
import pages.NewContactModal;

public class ContactSteps {
    ContactListPage contactListPage;
    NewContactModal newContactModal;
    ContactPage contactPage;
    ContactViewPage contactViewPage;

    public ContactSteps(WebDriver driver) {
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
        contactPage = new ContactPage(driver);
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

    public void updateContact(Contact contact_original, Contact contact_updated) {
        //contactListPage.openPage();
        //contactListPage.openContact(contact_original);
        contactViewPage.updateOpenContact(contact_updated);
    }

    public void removeAccount(Contact contact) {
        contactListPage.openPage();
        contactListPage.openContact(contact);
        contactPage.deleteOpenedContact();
    }
}
