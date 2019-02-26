package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.FileUtil;

import java.util.logging.Logger;

public class HomePage extends NavBarPage {
    @FindBy(css = ".content img")
    private WebElement bannerElement;

    private static Logger logger =Logger.getLogger("aaaa");

    public static HomePage start(){
        Driver.start();
        WebDriver driver = Driver.getDriver();
        driver.get(FileUtil.getConfig().homeUrl);

        logger.info("getTitle "+Driver.getDriver().getTitle());
        logger.info("getCurrentUrl"+Driver.getDriver().getCurrentUrl());
        logger.info("getPageSource"+Driver.getDriver().getPageSource());
        logger.info("getWindowHandle"+Driver.getDriver().getWindowHandle());
        logger.info("getWindowHandles"+Driver.getDriver().getWindowHandles());
        return new HomePage();
    }

    private HomePage() {
        super();
        Driver.webDriverWait().until(ExpectedConditions.titleIs("TesterHome"));
    }

    public EventPage gotoBannerPage(){
        String handle = Driver.getDriver().getWindowHandle();
        bannerElement.click();
        Driver.webDriverWait().until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String h: Driver.getDriver().getWindowHandles()){
            if (!h.contentEquals(handle)){
                Driver.getDriver().switchTo().window(h);
            }
        }
        logger.info("getWindowHandle "+Driver.getDriver().getWindowHandle());
        return new EventPage("第五届移动互联网测试开发大会");
    }
}
