package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.FileUtil;
import utils.SeleniumUtil;

import java.util.Set;

public class HomePage extends NavBarPage {
    @FindBy(css = ".content img")
    private WebElement bannerElement;

    public static HomePage start(){
        Driver.start();
        WebDriver driver = Driver.getDriver();
        driver.get(FileUtil.getConfig().homeUrl);

        return new HomePage();
    }

    private HomePage() {
        super();
        Driver.webDriverWait().until(ExpectedConditions.titleIs("TesterHome"));
    }

    public EventPage gotoBannerPage(){
        Set<String> exHandles = Driver.getDriver().getWindowHandles();

        bannerElement.click();
        SeleniumUtil.switchWindow(exHandles);

        return new EventPage("第五届移动互联网测试开发大会");
    }
}
