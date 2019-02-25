package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends NavBarPage {
    @FindBy(css = ".topic")
    private List<WebElement> resultElementsForTitle;
    @FindBy(css = ".desc")
    private List<WebElement> resultElementsForDesc;

    SearchPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver,30).until(ExpectedConditions.titleContains("搜索结果"));
    }

    public List<WebElement> getSearchResultsForTitle(){
        return resultElementsForTitle;
    }

    public List<WebElement> getSearchResultsForDesc(){
        return resultElementsForDesc;
    }

}
