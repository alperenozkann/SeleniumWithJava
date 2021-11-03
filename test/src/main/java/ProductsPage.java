import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By filterAndSortLocator = By.id("#filter-label");

    By productNameLocator = By.cssSelector(".a_model_item ");

    By findMoreItemLocator = By.cssSelector(".lazy-load-button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(int index) {
        getAllProducts().get(index).click();
    }

    public boolean isOnProductPage() {
        return isDisplayed(filterAndSortLocator);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
    public void findMoreProduct(){
        click(findMoreItemLocator);
    }
    public int randomNumber(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}
