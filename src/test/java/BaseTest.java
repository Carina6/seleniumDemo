import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import page.HomePage;

class BaseTest {
    HomePage homePage;
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = Driver.start();
        homePage = new HomePage(driver);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
