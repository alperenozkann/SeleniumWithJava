import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.id("search_input");

    By submitButtonLocator = By.cssSelector("button[class='searchButton']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String product) {
        driver.findElement(By.id("search_input")).clear();
        type(searchBoxLocator, product);
        click(submitButtonLocator);
        }
}

