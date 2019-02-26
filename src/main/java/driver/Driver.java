package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtil;

import java.io.File;

public class Driver {
    public static WebDriver start() {
        setDriverPath();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static void setDriverPath() {
        String os = System.getProperty("os.name");
        String path = "";
        if (os.toLowerCase().startsWith("win")) {
            path = "src/main/resources/driver/chromedriver.exe";
        }
        if (os.toLowerCase().startsWith("mac")) {
            path = "src/main/resources/driver/chromedriver_mac";
        }
        if (os.toLowerCase().startsWith("linux")) {
            path = "src/main/resources/driver/chromedriver_linux";
        }

        File file = new File(path);
        System.setProperty("webdriver.chrome.driver", file.getAbsoluteFile().toString());

    }

    public static WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, FileUtil.getConfig().timeOut);
    }

    public static WebDriverWait webDriverWait(WebDriver driver, Integer timeOut){
        return new WebDriverWait(driver, timeOut);
    }
}
