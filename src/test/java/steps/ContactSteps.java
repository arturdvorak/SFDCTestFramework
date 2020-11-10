package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.ContactViewPage;
import pages.NewContactModal;

@Log4j2
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
        log.atInfo().log("Create new contact with name {}", contact.getAccountName());
        contactListPage
                .openPage()
                .openNewContactModal();
        newContactModal
                .fillOutNewContactModal(contact)
                .saveContact();
        return this;
    }

    @Step("Validate contact with name {contact.firstName} {contact.lastName}")
    public ContactSteps validationOfContact(Contact contact) {
        log.atInfo().log("Validate account with name {} {}", contact.getFirstName(), contact.getLastName());
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .validateContactData(contact);
        return this;
    }

    @Step("Update contact {contact.firstName} {contact.lastName} data to contact {contact_updated.firstName} {contact_updated.lastName} data")
    public ContactSteps updateContact(Contact contact, Contact contact_updated) {
        log.atInfo().log("Update contact {} {} data to contact {} {} data",
                contact.getFirstName(), contact.getLastName(), contact_updated.getFirstName(), contact_updated.getLastName());
        contactListPage
                .openPage()
                .openContact(contact);
        contactViewPage
                .updateOpenContact(contact_updated);
        return this;
    }

    @Step("Remove contact with name {contact_updated.firstName} {contact_updated.lastName}")
    public ContactSteps removeContact(Contact contact_updated) {
        log.atInfo().log("Remove contact with name {} {}", contact_updated.getFirstName(), contact_updated.getLastName());
        contactListPage
                .openPage();
        contactViewPage
                .deleteContactByName(contact_updated);
        return this;
    }
}
