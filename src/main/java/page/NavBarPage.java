package page;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBarPage {
    @FindBy(css = ".form-control")
    private WebElement searchWebElement;

    @FindBy(css = ".nav a[href='/teams']")
    private WebElement teamsElement;

    @FindBy(css = ".team-name[data-name=\"霍格沃兹测试学院\"]")
    private WebElement hogwartsElement;

    NavBarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public SearchPage gotoSearchPage(String keyword){
        searchWebElement.clear();
        searchWebElement.sendKeys(keyword);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();

        return new SearchPage();
    }

    public HogwartsPage gotoHogwartsPage(){
        teamsElement.click();

        Driver.webDriverWait().until(ExpectedConditions.titleContains("社团"));
        hogwartsElement.click();

        return new HogwartsPage();
    }
}
