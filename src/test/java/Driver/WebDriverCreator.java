package Driver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
    protected WebDriverCreator () {
    }

    public abstract WebDriver factoryMethod();
}
