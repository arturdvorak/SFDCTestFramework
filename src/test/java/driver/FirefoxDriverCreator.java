package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverCreator extends WebDriverCreator {
    private static final String FIREFOX_DRIVER = "geckodriver.exe";
    private static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
    private static final String driverPath = "src/test/resources/";

    public WebDriver factoryMethod() {
        System.setProperty(FIREFOX_PROPERTY, driverPath+FIREFOX_DRIVER);
        DesiredCapabilities capabilities = getCapabilities();
        capabilities.setPlatform(Platform.ANY);
        capabilities.setCapability(FirefoxDriver.PROFILE, getFirefoxProfile());
        return new FirefoxDriver();
    }

    private FirefoxProfile getFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("toolkit.startup.max_resumed_crashes", "-1");
        return profile;
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return capabilities;
    }
}
