package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPage {
    private WebDriver driver;

    @FindBy(css = ".form-control")
    private WebElement searchWebElement;

    NavBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SearchPage gotoSearchPage(String keyword){
        searchWebElement.clear();
        searchWebElement.sendKeys(keyword);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        return new SearchPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
