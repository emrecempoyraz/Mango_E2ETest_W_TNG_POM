package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//li//button//span[@id='size-35']")
    WebElement sizeSelectionLocator;

    @FindBy (xpath = "//button[@id='productFormAdd']")
    private WebElement addToBasketButtonLocator;

    @FindBy (xpath = "//button[@class='text-body-m-regular liDtv T9iru M8OZL']")
    private WebElement checkTheBasketButtonLocator;


    public void selectSize() {
        sizeSelectionLocator.click();
    }

    public void addToBasket (){
        addToBasketButtonLocator.click();
    }

    public boolean isProductAddedToBasket () {
        String actualText = checkTheBasketButtonLocator.getText();
        String expectedText = "Sepeti görüntüle";
        return actualText.contains(expectedText);
    }

    public void goToBasket () {
        checkTheBasketButtonLocator.click();
    }

    public boolean isOnCartPage () {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://shop.mango.com/tr/cart" ;
        return actualUrl.equals(expectedUrl);
    }


}
