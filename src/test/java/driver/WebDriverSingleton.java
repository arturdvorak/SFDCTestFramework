package driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@Log4j2
public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance(BrowserType browserType) {
        if (null == driver) {
            driver = createDriver(browserType);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createDriver(BrowserType browserType) {
            WebDriverCreator creator;
            switch (browserType) {
                case FF:
                    creator = new FirefoxDriverCreator();
                    log.atInfo().log("FireFoxDriver initiating.");
                    break;
                case GC:
                    creator = new ChromeDriverCreator();
                    log.atInfo().log("ChromeDriver initiating.");
                    break;
                case IE:
                    creator = new InternetExplorerDriverCreator();
                    log.atInfo().log("InternetExplorerDriver initiating.");
                    break;
                default:
                    creator = new ChromeDriverCreator();
                    log.atInfo().log("ChromeDriver initiating as browser type is not provided.");
            }
            driver = creator.factoryMethod();
            return driver;
    }
}