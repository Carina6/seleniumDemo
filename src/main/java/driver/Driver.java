package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Driver {
    private static WebDriver driver;

    public static void start() {
        setDriverPath();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
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

    public static WebDriver getDriver() {
        return driver;
    }
}
