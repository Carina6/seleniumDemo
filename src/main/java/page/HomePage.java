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

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get(FileUtil.getConfig().homeUrl);
        Driver.webDriverWait(driver).until(ExpectedConditions.titleIs("TesterHome"));
    }

    public EventPage gotoBannerPage(){
        Set<String> exHandles = driver.getWindowHandles();

        bannerElement.click();
        SeleniumUtil.switchWindow(driver,exHandles);

        return new EventPage(driver,"第五届移动互联网测试开发大会");
    }
}
