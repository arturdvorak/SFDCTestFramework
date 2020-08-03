package tests;

import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    String lastNameContact = "Contact";
    String lastNameContactToRemove = "ContactMon Jul 27 16:58:27 EDT 2020";

/*    @Test
    public void createNewContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(lastNameContact);
    }*/

    @Test
    public void removeAccount() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.removeAccount(lastNameContactToRemove);
    }
}
