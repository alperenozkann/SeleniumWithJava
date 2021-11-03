import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        System.out.printf("Test basladı");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
       // driver.quit();
    }

    @BeforeEach
    public void beforeMethod(){

    }

    @AfterEach
    public void afterMethod(){
        System.out.println("test bitti");
       // driver.quit();
    }
}
