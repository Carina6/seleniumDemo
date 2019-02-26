package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends NavBarPage {
    @FindBy(css = ".topic")
    private List<WebElement> resultElementsForTitle;
    @FindBy(css = ".desc")
    private List<WebElement> resultElementsForDesc;

    SearchPage(WebDriver driver) {
        super(driver);
        Driver.webDriverWait(driver).until(ExpectedConditions.titleContains("搜索结果"));
    }

    public List<WebElement> getSearchResultsForTitle(){
        return resultElementsForTitle;
    }

    public List<WebElement> getSearchResultsForDesc(){
        return resultElementsForDesc;
    }

}
