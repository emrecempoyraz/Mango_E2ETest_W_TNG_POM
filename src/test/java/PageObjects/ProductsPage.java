package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{


    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy (css = "img[id=product-57065971]")
    private WebElement shoeLocator;

    @FindBy (xpath = "//button[@id='productFormAdd']")
    private WebElement addToBasketTextLocator;

    public void pickProduct () {
        shoeLocator.click();
    }


    public boolean isOnProductPage (){
        String actualText = addToBasketTextLocator.getText();
        String expectedText = "Sepete ekle";
        return actualText.contains(expectedText);

    }
}
