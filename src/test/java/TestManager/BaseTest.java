package TestManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver ;
    ChromeOptions options;


    @BeforeTest
    public void setUp () {
        driver = new ChromeDriver();
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        driver.get("https://shop.mango.com/tr/kadin");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));


    }

    @AfterTest
    public void tearDown (){
        driver.close();
    }



}
