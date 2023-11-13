import PageObjects.CartPage;
import PageObjects.MangoHomePage;
import PageObjects.ProductDetailPage;
import PageObjects.ProductsPage;
import TestManager.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MangoTestSelenium extends BaseTest {

    MangoHomePage homePage;
    ProductsPage productsPage ;

    ProductDetailPage productDetailPage ;

    CartPage cartPage ;

    @Test (priority = 1)
    public void homePage() {
        homePage = new MangoHomePage(driver);
        homePage.acceptCookies();
        homePage.searchShoe();
        Assert.assertTrue(homePage.isProductListed());
    }

    @Test (dependsOnMethods = "homePage", priority = 2)
    public void selectProduct () {

        productsPage = new ProductsPage(driver);
        productsPage.pickProduct();
        Assert.assertTrue(productsPage.isOnProductPage());
    }


    @Test (dependsOnMethods = "selectProduct", priority = 3)
    public void addProductToBasket (){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectSize();
        productDetailPage.addToBasket();
        Assert.assertTrue(productDetailPage.isProductAddedToBasket());
    }

    @Test (dependsOnMethods = "addProductToBasket", priority = 4)
    public void goToCart () {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.goToBasket();
        Assert.assertTrue(productDetailPage.isOnCartPage());
    }

    @Test (dependsOnMethods = "goToCart" , priority = 5)
    public void priceCompare () {
       cartPage = new CartPage(driver);
       Assert.assertTrue(cartPage.isPriceMatch());
    }
}
