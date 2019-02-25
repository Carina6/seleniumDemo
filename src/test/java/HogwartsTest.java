import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.HogwartsPage;
import page.HomePage;
import page.NotSignInPage;

class HogwartsTest {
    private HomePage homePage;
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        homePage = HomePage.start();
        driver = homePage.getDriver();
    }

    @Test
    void notSignInTest(){
        HogwartsPage hogwartsPage = homePage.gotoHogwartsPage();
        hogwartsPage.gotoPaper();

        NotSignInPage notSignInPage = new NotSignInPage(driver);
        Assertions.assertEquals("访问被拒绝，你可能没有权限或未登录。", notSignInPage.getAlertMsg());
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
