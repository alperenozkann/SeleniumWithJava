import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class IndexTest extends BaseTest{

    @Test
    public void test_HomePage(){
        IndexPage indexPage = new IndexPage(driver);
        Assertions.assertEquals("https://www.lcwaikiki.com/tr-TR/TR/",indexPage.baseUrl,"Ana Sayfada Değilsin");
    }


}
