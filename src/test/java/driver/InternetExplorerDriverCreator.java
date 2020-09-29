package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverCreator extends WebDriverCreator {
    private static final String IE_DRIVER = "IEDriverServer.exe";
    private static final String IE_PROPERTY = "webdriver.ie.driver";
    private static final String driverPath = "src/test/resources/";

    public WebDriver factoryMethod() {
        System.setProperty(IE_PROPERTY, driverPath+IE_DRIVER);
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
}
