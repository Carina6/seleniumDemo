package utils;

import driver.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class SeleniumUtil {
    public static void switchWindow(Set<String> handles){
        Driver.webDriverWait().until(ExpectedConditions.numberOfWindowsToBe(handles.size()+1));
        for(String handle: Driver.getDriver().getWindowHandles()){
            if(!handles.contains(handle)){
                Driver.getDriver().switchTo().window(handle);
                return;
            }
        }
    }
}
