import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.SearchPage;

import java.util.List;

class SearchTest {
    private HomePage homePage;

    @BeforeEach
    void setUp(){
        homePage = HomePage.start();
    }

    @ParameterizedTest
    @CsvSource({
            "selenium",
            "appium"
    })
//    @CsvFileSource(resources = "/searchData.csv")
    void searchTest(String keyword){
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
        Driver.getDriver().quit();
    }
}
