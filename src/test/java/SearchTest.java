import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.io.File;
import java.util.List;

public class SearchTest {
    WebDriver driver;
    String path = "src/main/resources/driver/chromedriver";

    HomePage homePage;

    @BeforeMethod
    void setUp(){
        File file = new File(path);
        System.setProperty("webdriver.chrome.driver", file.getAbsoluteFile().toString());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

//        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        homePage = new HomePage(driver);
    }

    @Test
    public void test(){
        driver.get("https://testerhome.com/");

        String keyword = "selenium";

        SearchPage searchPage = homePage.gotoSearchPage(keyword);
        List<WebElement> resultsForTitle = searchPage.getSearchResultsForTitle();
        List<WebElement> resultsForDesc = searchPage.getSearchResultsForDesc();

        String result;
        for(int i=0;i<resultsForTitle.size();i++){
            result = resultsForTitle.get(i).getText().trim();
            try {
                Assert.assertTrue(result.toLowerCase().contains(keyword.toLowerCase()));
            } catch (AssertionError e){
                result = resultsForDesc.get(i).getText().trim();
                Assert.assertTrue(result.toLowerCase().contains(keyword.toLowerCase()));
            }
        }

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
