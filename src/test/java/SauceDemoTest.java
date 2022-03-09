import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import page_objects.ItemsName;
import page_objects.SauceDemoInventoryPage;
import page_objects.SauceDemoLoginPage;

public class SauceDemoTest {

    protected static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";
    UtilClass utilClass;


    @Before
    public void setUp(){
        utilClass = new UtilClass();
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
        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoLoginTest(){

        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoItemAddTest(){
        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver, ItemsName.backpack);
        inventoryPage.addToCart();

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

        utilClass.logInfo(driver.getCurrentUrl());
    }

    @Test
    public void sauceDemoItemDetailsTest(){
        driver.get(URL);

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver, ItemsName.backpack);
        inventoryPage.openItemPage(1);

        utilClass.logInfo(driver.getCurrentUrl());
    }

}
