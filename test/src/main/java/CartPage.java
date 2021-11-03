import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By productNameLocator = By.cssSelector("row mb-5");
    By productPriceLocator = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-4.col-xs-3.text-right.sc-option-detail.pl-0 > span");
    By productPriceLocatorDiscount = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-4.col-xs-3.text-right.sc-option-detail.pl-0 > span.rd-cart-item-price.mb-15");
    By addOneMoreProductToCartLocator = By.cssSelector(".oq-up plus");
    By deleteProductLocator = By.cssSelector(".fa fa-trash-o");

    String cardprice;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkPriceWithCardPrice(String price) {
        if ( driver.findElement(productPriceLocatorDiscount).getText() != null){
            cardprice = driver.findElement(productPriceLocatorDiscount).getText();
        }else {
            cardprice = driver.findElement(productPriceLocator).getText();
        }
       if (cardprice.equals(price)){
           return true;
       }else
           return false;
    }

    public boolean addOneMoreProductToCart(){
        click(addOneMoreProductToCartLocator);
        String oldCardPrice = cardprice;
        if ( driver.findElement(productPriceLocatorDiscount).getText() != null){
            if (!oldCardPrice.equals(driver.findElement(productPriceLocator))){
                return true;
            }else
                return false;
        }else {
            if (!oldCardPrice.equals(driver.findElement(productPriceLocatorDiscount))){
                return true;
            }else
                return false;
        }
    }
    public boolean deleteProduct(){

       if (!deleteProductLocator.equals(null)){
           click(deleteProductLocator);
           return true;
       }else
           return false;
    }
}
