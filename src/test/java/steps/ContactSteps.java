package steps;

import io.qameta.allure.Step;
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

    @Step(value = "Create new contact with name {contact.firstName} {contact.lastName}")
    public ContactSteps createNewContact(Contact contact) {
        contactListPage
                .openPage()
                .openNewContactModal();
        newContactModal
                .fillOutNewContactModal(contact)
                .saveContact();
        return this;
    }

    @Step("Validate account with name {contact.firstName} {contact.lastName}")
    public ContactSteps validationOfContact(Contact contact) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .validateContactData(contact);
        return this;
    }

    @Step("Update contact {contact.firstName} {contact.lastName} data to contact {contact_updated.firstName} {contact_updated.lastName} data")
    public ContactSteps updateContact(Contact contact, Contact contact_updated) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .updateOpenContact(contact_updated);
        return this;
    }

    @Step("Remove account with name {contact_updated.firstName} {contact_updated.lastName}")
    public ContactSteps removeContact(Contact contact) {
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .deleteOpenedContact();
        return this;
    }
}
