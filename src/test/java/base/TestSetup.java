package base;

import enums.Browser;
import enums.OS;
import helper.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSetup {
    public static WebDriver driver;

    protected void selectBrowser(String browser,boolean runRemote) throws MalformedURLException {

        if (runRemote){
            if(browser.equalsIgnoreCase(Browser.CHROME.name())) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL(Constants.SELENIUM_GRID_URL), capabilities);
            }
            else if(browser.equalsIgnoreCase(Browser.FIREFOX.name())){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL(Constants.SELENIUM_GRID_URL), capabilities);
            }
        }
        else if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOWS.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains(OS.MACOS.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
        new BasePage();
        driver.get(Constants.APP_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    protected void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    private String getPageTitle(){
        return driver.getTitle();
    }
    protected boolean isPageTitle(String title){
        return getPageTitle().contains(title);
    }
}
