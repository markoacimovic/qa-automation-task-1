package page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

public class SauceDemoInventoryPage {

    private WebDriver driver;
    private ItemsName itemsName;

    private WebElement getItem(ItemsName itemName){
        return driver.findElement(By.name("add-to-cart-sauce-labs-" + itemName));
    }

    private WebElement getItemLink(Integer id){
        return driver.findElement(By.id("item_"+ id +"_img_link"));
    }

    private WebElement getCart(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public SauceDemoInventoryPage(WebDriver driver, ItemsName itemsName) {
        this.driver = driver;
        this.itemsName = itemsName;
    }

    public void addToCart(){
        getItem(this.itemsName).click();
    }
    public boolean checkCart(){
        String cartNumber = getCart().getText();
        return Integer.parseInt(cartNumber) == 1;
    }
    public void openItemPage(Integer id){
        getItemLink(id).click();
    }
}
