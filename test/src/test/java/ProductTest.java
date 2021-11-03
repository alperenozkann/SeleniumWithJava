import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import org.openqa.selenium.JavascriptExecutor;


public class ProductTest extends BaseTest{

    IndexPage indexPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    @Test
    @Order(1)
    public void search_Product(){
        indexPage = new IndexPage(driver);
        productsPage = new ProductsPage(driver);
        indexPage.searchBox().search("Pantolon");
        Assertions.assertTrue(productsPage.isOnProductPage(),"Arama Sayfasinda Degilsiniz !");
    }
    @Test
    @Order(2)
    public void scroll_Down_And_Find_More(){
        productDetailPage = new ProductDetailPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        productsPage.findMoreProduct();
    }
    @Test
    @Order(3)
    public void select_Product(){
        int random = productsPage.randomNumber(48,50);
        productsPage.selectProduct(random);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Urun Detay Sayfasına Gidilemedi !");
    }

    @Test
    @Order(4)
    public void add_Product_To_Cart(){
        productDetailPage.addToCart();
        productDetailPage.selectProductSize(0);
        //Assertions.assertTrue(indexPage.isProductCountUp(),"Urun Sayisi Artmadi !" );
    }
    @Test
    @Order(5)
    public void go_Cart_Page(){
        productDetailPage.goToCartPage();
    }

    @Test
    @Order(6)
    public void checkPriceWithCardPrice(){
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.checkPriceWithCardPrice(productDetailPage.price),"Verilen Fiyatlar Uyumsuz !");
    }
    @Test
    @Order(7)
    public void addOneMoreProduct(){
        Assertions.assertTrue(cartPage.addOneMoreProductToCart());
    }
    @Test
    @Order(8)
    public void deleteProduct(){
        Assertions.assertTrue(cartPage.deleteProduct());
    }


}
