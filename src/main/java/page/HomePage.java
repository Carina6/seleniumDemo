package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import utils.FileUtil;

public class HomePage extends NavBarPage {

    public static HomePage start(){
        Driver.start();
        WebDriver driver = Driver.getDriver();
        driver.get(FileUtil.getConfig().homeUrl);

        return new HomePage(driver);
    }

    private HomePage(WebDriver driver) {
        super(driver);
    }
}
