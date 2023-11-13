package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div//div[@class='ezes7 kBC9T'])[1]")
    private WebElement productPrice ;

    @FindBy(xpath = "(//div//div[@class='ezes7 kBC9T'])[2]")
    private WebElement cartPrice ;


    public boolean isPriceMatch () {
        boolean isPriceMatch = false;
        String actualCartPrice = cartPrice.getText();
        String expectedProductPrice = productPrice.getText();
        if (actualCartPrice.equals(expectedProductPrice)) isPriceMatch = true ;
        return isPriceMatch;


    }




}
