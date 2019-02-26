package utils;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class SeleniumUtil {
    public static void switchWindow(WebDriver driver, Set<String> handles) {
        Driver.webDriverWait(driver).until(ExpectedConditions.numberOfWindowsToBe(handles.size() + 1));
        for (String handle : driver.getWindowHandles()) {
            if (!handles.contains(handle)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }
}
