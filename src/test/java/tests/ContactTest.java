package tests;

import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test
    public void createNewContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        homeSteps.createNewContact();
    }
}
