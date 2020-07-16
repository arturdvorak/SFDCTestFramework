package Driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    public WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            driver = createDriver();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
    private static WebDriver createDriver() {
        WebDriverCreator creator = new ChromeDriverCreator();
        driver = creator.factoryMethod();
        return driver;
    }
}