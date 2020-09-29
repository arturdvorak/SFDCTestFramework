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

    public ContactSteps createNewContact(Contact contact) {
        contactListPage
                .openPage()
                .openNewContactModal();
        newContactModal
                .fillOutNewContactModal(contact)
                .saveContact();
        return this;
    }

    public ContactSteps validationOfContact(Contact contact) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .validateContactData(contact);
        return this;
    }

    public ContactSteps updateContact(Contact contact, Contact contact_updated) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .updateOpenContact(contact_updated);
        return this;
    }

    public ContactSteps removeContact(Contact contact) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .deleteOpenedContact();
        return this;
    }
}
