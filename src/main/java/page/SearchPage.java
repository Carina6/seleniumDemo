package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends NavBarPage {
    @FindBy(css = ".topic")
    private List<WebElement> resultElementsForTitle;
    @FindBy(css = ".desc")
    private List<WebElement> resultElementsForDesc;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsForTitle(){
        return resultElementsForTitle;
    }

    public List<WebElement> getSearchResultsForDesc(){
        return resultElementsForDesc;
    }

}
