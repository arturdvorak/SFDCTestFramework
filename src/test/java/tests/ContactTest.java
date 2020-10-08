package tests;

import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    ContactFactory contactFactory = new ContactFactory();

    @Test(enabled=false)
    public void createAndRemoveContact() {
        loginSteps
                .open()
                .login(username, password);
        Contact contact = contactFactory.getContact("Test1", "Test1 Department", "HeadContact1");
        Contact contactUpdated = contactFactory.getContact("Test2", "Test2 Department", "HeadContact2");
        contactSteps
                .createNewContact(contact)
                .validationOfContact(contact)
                .updateContact(contact, contactUpdated)
                .validationOfContact(contactUpdated)
                .removeContact(contactUpdated);
    }
}
