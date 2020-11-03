package base;


import org.openqa.selenium.WebDriver;

public class BasePage {

    protected static WebDriver driver;
    public BasePage() {
        setWebDriver(driver);
    }
    public void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
