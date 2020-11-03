package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static java.lang.System.setProperty;

public class ChromeDriverCreator extends WebDriverCreator {
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER = "chromedriver";
    //private static final String driverPath = "src/test/resources/";
    private static final String driverPath = "src/test/resources";
    private ChromeOptions options;
    private static String osName = System.getProperty("os.name").toLowerCase();

    public WebDriver factoryMethod() {
        if (osName.contains("win")) {
            setProperty(CHROME_PROPERTY, driverPath + "/chromedriver.exe");
        } else if (osName.contains("mac")) {
            setProperty(CHROME_PROPERTY, driverPath + "/chromedriver");
        } else {
            setProperty(CHROME_PROPERTY, driverPath + "/linux/chromedriver");
        }
        //setProperty(CHROME_PROPERTY, driverPath+CHROME_DRIVER);
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return options;
    }
}
