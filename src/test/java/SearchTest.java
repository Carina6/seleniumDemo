import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.SearchPage;

import java.util.List;

class SearchTest {
    private HomePage homePage;
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        homePage = HomePage.start();
        driver = homePage.getDriver();
    }

    @ParameterizedTest
    @CsvSource({
            "selenium",
            "appium"
    })
//    @CsvFileSource(resources = "/searchData.csv")
    void searchTest(String keyword){
//        driver.get("https://testerhome.com/");

        SearchPage searchPage = homePage.gotoSearchPage(keyword);
        List<WebElement> resultsForTitle = searchPage.getSearchResultsForTitle();
        List<WebElement> resultsForDesc = searchPage.getSearchResultsForDesc();

        String result;
        for(int i=0;i<resultsForTitle.size();i++){
            result = resultsForTitle.get(i).getText().trim();
            try {
                Assertions.assertTrue(result.toLowerCase().contains(keyword.toLowerCase()));
            } catch (AssertionError e){
                result = resultsForDesc.get(i).getText().trim();
                Assertions.assertTrue(result.toLowerCase().contains(keyword.toLowerCase()));
            }
        }

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
