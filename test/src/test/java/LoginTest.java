import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{


    @Test
    public void test_Login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("alperenozkan58@gmail.com");
        loginPage.setPassword("testsifresi1234");
        Assertions.assertEquals( "alperenozkan58@gmail.com",loginPage.getEmail(),"Email Yanlis Girildi!");
        Assertions.assertEquals( "testsifresi1234",loginPage.getPassword(),"Sifre Yanlis Girildi!");
        loginPage.click(By.id("loginLink"));
        Assertions.assertNotEquals("https://www.lcwaikiki.com/tr-TR/TR/giris",driver.getCurrentUrl(),"Login Basarısız");
    }

}
