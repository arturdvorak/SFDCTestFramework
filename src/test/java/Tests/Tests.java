package Tests;

import Models.User;
import Steps.Steps;
import Utils.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
    private Steps steps;

    User user = new User(Utils.getProperty("USERNAME"), Utils.getProperty("PASSWORD"));

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
    }

    @Test
    public void loginToSFDC() {
        steps.openStartPage(Utils.getProperty("BASE_URL"));
        steps.openLoginPage(Utils.getProperty("LOGIN_URL"));
        steps.loginToSFDC(user.getUsername(), user.getPassword());
    }
}
