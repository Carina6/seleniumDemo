import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BannerTest extends BaseTest{
    @Test
    void bannerTest() {
        System.out.println("线程："+Thread.currentThread());
        String title = homePage.gotoBannerPage().getTitle();
        System.out.println("banner title:"+title);
        Assertions.assertTrue(title.contains("第五届移动互联网测试开发大会"));
    }

}
