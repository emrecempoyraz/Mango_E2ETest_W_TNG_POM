package PageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangoHomePage extends BasePage {

    public MangoHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@class='text-body-m-regular liDtv vzD0D Nio8J']")
    private WebElement acceptCookiesLocator ;

    @FindBy (id = "searchIconButton")
    private WebElement searchButtonLocator;

    @FindBy (xpath = "//input[@data-testid='header.search.input']")
    private WebElement searchText;

    @FindBy (xpath = "//span[text()=' ayakkabı']")
    private WebElement searchResultTextLocator;



    public void acceptCookies () {
        acceptCookiesLocator.click();
    }

    public void searchShoe (){
        searchButtonLocator.click();
        searchText.sendKeys("ayakkabı" + Keys.ENTER);
    }

    public boolean isProductListed1 () {
        boolean isProductListed = false;
        String searchText = searchResultTextLocator.getText();
        String expectedSearchText = "AYAKKABI";
        if (searchText.equals(expectedSearchText)) isProductListed = true;
        return isProductListed;
    }

    public boolean isProductListed () {
        String searchText = searchResultTextLocator.getText();
        String expectedSearchText = "AYAKKABI";
        return searchText.equals(expectedSearchText);
    }
}
