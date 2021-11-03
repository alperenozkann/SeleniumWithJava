import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By productSizeNameLocator = By.cssSelector("#option-size > a:nth-child(6)");
    By productSizeNameLocator2 = By.cssSelector("#option-size > a:nth-child(7)");
    By productSizeNameLocator3 = By.cssSelector("#option-size > a:nth-child(8)");

    By ProductSizeNameLocatorHeight = By.cssSelector("#option-height > a:nth-child(3)");
    By ProductSizeNameLocatorHeight2 = By.cssSelector("#option-height > a:nth-child(4)");
    By ProductSizeNameLocatorHeight3 = By.cssSelector("#option-height > a:nth-child(5)");

    By productPriceLocator = By.cssSelector("#rightInfoBar > div:nth-child(1) > div > div:nth-child(3) > div > div > div > span.price");
    By productPriceLocatorDiscount = By.cssSelector("#rightInfoBar > div:nth-child(1) > div > div:nth-child(3) > div > div > div.campaign-discount-detail > div.basket-discount");
    By cartPageLocator = By.cssSelector("body > div:nth-child(13) > div.container-fluid.header > div:nth-child(2) > div.col-md-3.col-sm-3.col-xs-6.col-lg-2.pull-right > div > div.col-sm-4.col-xs-4.header-cart-section > a > i");
    String price;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        if (driver.findElement(productPriceLocatorDiscount).getText()!=null){
            price = driver.findElement(productPriceLocatorDiscount).getText();
        }else {
            price = driver.findElement(productPriceLocator).getText();
        }
        if (!productSizeNameLocator.equals(null)){
            click(productSizeNameLocator);
        } else if (!productSizeNameLocator2.equals(null)){
            click(productSizeNameLocator2);
        } else{
            click(productSizeNameLocator3);
        }


        if (!ProductSizeNameLocatorHeight.equals(null)){
            click(ProductSizeNameLocatorHeight);
        }else if (!ProductSizeNameLocatorHeight2.equals(null)){
            click(ProductSizeNameLocatorHeight2);
        } else if (!ProductSizeNameLocatorHeight3.equals(null)){
            click(ProductSizeNameLocatorHeight3);
        }

        click(addToCartButtonLocator);
    }
    public void goToCartPage(){
        click(cartPageLocator);
    }

    public void selectProductSize(int i) {
        getAllProductSizes().get(i).click();
    }

    private List<WebElement> getAllProductSizes(){
        return findAll(productSizeNameLocator);
    }



}
