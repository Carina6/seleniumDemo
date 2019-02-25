package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {
    private WebDriver driver;

    @FindBy(css = ".form-control")
    private WebElement searchWebElement;

    @FindBy(css = ".nav a[href='/teams']")
    private WebElement teamsElement;

    @FindBy(css = ".team-name[data-name=\"霍格沃兹测试学院\"]")
    private WebElement hogwartsElement;

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

    public HogwartsPage gotoHogwartsPage(){
        teamsElement.click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleContains("社团"));
        hogwartsElement.click();

        return new HogwartsPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
