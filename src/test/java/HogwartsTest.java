import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.NotSignInPage;

class HogwartsTest extends BaseTest{
    @Test
    void notSignInTest(){
        System.out.println("线程："+Thread.currentThread());
        homePage.gotoHogwartsPage().gotoPaper();

        NotSignInPage notSignInPage = new NotSignInPage(driver);
        Assertions.assertEquals("访问被拒绝，你可能没有权限或未登录。", notSignInPage.getAlertMsg());
    }

}
