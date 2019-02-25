package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HogwartsPage extends NavBarPage {
    @FindBy(css = ".title a")
    private List<WebElement> topicElements;

    HogwartsPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver,30).until(ExpectedConditions.titleIs("TesterHome"));
    }

    public void gotoPaper(){
        topicElements.get(0).click();
    }
}
