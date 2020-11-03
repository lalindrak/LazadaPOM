package tests;

import base.BaseTest;
import functions.homepage.Home;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Property;

public class InitialTest extends BaseTest {
    Home lazada;
    SoftAssert softAssert = new SoftAssert();
    Property property = new Property("homepagedata");

    @Test
    private void testSearchFunctionality(){
        lazada = new Home();
        lazada.performSearch("Apple iPhone 12");
        softAssert.assertTrue(isPageTitle("Apple iPhone 12"),"Page title is not correct");
        softAssert.assertAll();
    }

    @Test
    private void testBasicHomePageDataValidation(){
        lazada = new Home();
        softAssert.assertEquals(lazada.getFirstLevelMenuItems(),Integer.parseInt(property.getDataProperty("firstLevelMenuItems")));
        softAssert.assertAll();
    }
}
