package functions.homepage;

import pages.homepage.HomePage;

public class Home {
    HomePage homePage = new HomePage();

    public void performSearch(String searchKey){
        homePage.enterSearchItem(searchKey);
        homePage.clickSearchBtn();
    }

    public int getFirstLevelMenuItems(){
        return homePage.getFirstLevelMenuItems();
    }
}
