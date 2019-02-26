package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventPage {
    private WebDriver driver;

    EventPage(WebDriver driver, String title) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Driver.webDriverWait(driver).until(ExpectedConditions.titleContains(title));
    }

    public String getTitle(){
        return driver.getTitle();
    }

}
