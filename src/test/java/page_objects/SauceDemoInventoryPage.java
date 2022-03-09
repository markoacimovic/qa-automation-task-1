package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoInventoryPage {

    private WebDriver driver;
    private ItemsName itemsName;

    //get item by name
    private WebElement getItem(ItemsName itemName){
        return driver.findElement(By.name("add-to-cart-sauce-labs-" + itemName));
    }

    //get item link by id
    private WebElement getItemLink(Integer id){
        return driver.findElement(By.id("item_"+ id +"_img_link"));
    }

    //get cart with class name
    private WebElement getCart(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public SauceDemoInventoryPage(WebDriver driver, ItemsName itemsName) {
        this.driver = driver;
        this.itemsName = itemsName;
    }

    //add selected item to cart
    public void addToCart(){
        getItem(this.itemsName).click();
    }

    //checking if cart badge number is 1
    public boolean checkCart(){
        String cartNumber = getCart().getText();
        return Integer.parseInt(cartNumber) == 1;
    }

    //open item details page with id
    public void openItemPage(Integer id){
        getItemLink(id).click();
    }
}
