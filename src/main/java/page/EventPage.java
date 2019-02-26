package page;

import driver.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventPage {

    EventPage(String title) {
        PageFactory.initElements(Driver.getDriver(),this);
        Driver.webDriverWait().until(ExpectedConditions.titleContains(title));
    }

    public String getTitle(){
        return Driver.getDriver().getTitle();
    }

}
