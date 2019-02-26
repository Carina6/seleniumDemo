import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.NotSignInPage;

class HogwartsTest {
    private HomePage homePage;

    @BeforeEach
    void setUp(){
        homePage = HomePage.start();
    }

    @Test
    void notSignInTest(){
        homePage.gotoHogwartsPage().gotoPaper();

        NotSignInPage notSignInPage = new NotSignInPage();
        Assertions.assertEquals("访问被拒绝，你可能没有权限或未登录。", notSignInPage.getAlertMsg());
    }

    @AfterEach
    void tearDown(){
        Driver.getDriver().quit();
    }
}
