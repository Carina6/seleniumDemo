package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HogwartsPage extends NavBarPage {
    @FindBy(css = ".title a")
    private List<WebElement> topicElements;

    HogwartsPage() {
        super();
        Driver.webDriverWait().until(ExpectedConditions.titleIs("TesterHome"));
    }

    public void gotoPaper(){
        topicElements.get(0).click();
    }
}
