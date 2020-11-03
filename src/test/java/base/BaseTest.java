package base;

import enums.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest extends TestSetup {

    @BeforeClass
    public void startTests() throws MalformedURLException {
        selectBrowser(Browser.CHROME.name(),false);
    }

    @AfterClass
    public void stopTests(){
        tearDown();
    }
}
