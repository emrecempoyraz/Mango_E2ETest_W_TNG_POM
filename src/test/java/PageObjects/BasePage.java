package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {
    public WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    protected ExpectedCondition<WebElement> waitForElement(WebElement element){
        return ExpectedConditions.visibilityOf(element);
    }
}
