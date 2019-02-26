package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotSignInPage extends NavBarPage {
    @FindBy(css = ".alert-danger")
    private WebElement alertElement;

    public NotSignInPage() {
        Driver.webDriverWait().until(ExpectedConditions.titleContains("登录"));
    }

    public String getAlertMsg(){
        return alertElement.getText();
    }

}
