import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_objects.ItemsName;
import page_objects.SauceDemoInventoryPage;
import page_objects.SauceDemoLoginPage;
import util.BrowserClass;
import util.UtilClass;

public class SauceDemoTest {

    protected static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";
    UtilClass utilClass;


    /*
    *WebDriverManager is an open-source Java library that carries out the management
    *(i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver
    *(e.g., chromedriver, geckodriver, msedgedriver, etc.) in a fully automated manner.
    *In addition, WebDriverManager provides other relevant features, such as the capability
    *to discover browsers installed in the local system, building WebDriver objects
    *(such as ChromeDriver, FirefoxDriver, EdgeDriver, etc.).
    * */
    @Before
    public void setUp(){
        utilClass = new UtilClass();
        //Loading browser driver
        if(BrowserClass.BROWSER.equals("c")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(BrowserClass.BROWSER.equals("e")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(BrowserClass.BROWSER.equals("m")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void sauceDemoGetTest(){
        driver.get(URL);
        //Logging current URL
        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoLoginTest(){

        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        //Logging current URL
        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoItemAddTest(){
        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver, ItemsName.backpack);
        inventoryPage.addToCart();
        //Logging current URL
        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoCartCheckTest(){
        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver, ItemsName.backpack);
        inventoryPage.addToCart();


        Assert.assertTrue("Cart badge should have 1 item", inventoryPage.checkCart());
        //Logging current URL
        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoItemDetailsTest(){
        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver, ItemsName.backpack);
        inventoryPage.openItemPage(1);
        //Logging current URL
        utilClass.logInfo(driver.getCurrentUrl());
    }

}
