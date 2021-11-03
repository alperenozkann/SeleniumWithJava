import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{


    private final By eMailLocator = By.id("LoginEmail");
    private final By passwordLocator = By.id("Password");

    public LoginPage(WebDriver driver){
        super(driver);
        String newUrl = baseUrl.concat("giris");
        driver.get(baseUrl.concat("giris"));
    }

    public void setEmail(String email){
        type(eMailLocator,email);
    }
    public void setPassword(String password){
        type(passwordLocator,password);
    }
    public String getEmail(){
        return find(eMailLocator).getAttribute("value");
    }
    public String getPassword(){
        return find(passwordLocator).getAttribute("value");
    }


}
