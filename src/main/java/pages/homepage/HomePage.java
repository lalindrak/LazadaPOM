package pages.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "q")
    WebElement inputSearchBox;

    @FindBy(xpath = "//button[text()='SEARCH']")
    WebElement btnSearch;

    @FindAll(@FindBy(xpath = "//ul[@class='lzd-site-menu-root']/li"))
    List<WebElement> listMenu;
    //

    public void enterSearchItem(String searchKey){
        inputSearchBox.sendKeys(searchKey);
    }
    public void clickSearchBtn(){
        btnSearch.click();
    }

    public int getFirstLevelMenuItems(){
        int number = 0;
        for(int i =0; i < listMenu.size();i++){
            number++;
        }
        return number;
    }
}
