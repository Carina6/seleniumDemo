import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;

class BannerTest {
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = HomePage.start();
    }

    @Test
    void bannerTest() {
        Assertions.assertTrue(homePage.gotoBannerPage().getTitle().contains("第五届移动互联网测试开发大会"));
    }

    @AfterEach
    void tearDown() {
        Driver.getDriver().quit();
    }
}
