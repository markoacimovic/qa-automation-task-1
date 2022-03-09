package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {

    private WebDriver driver;


    //get input username field
    private WebElement getUsernameField(){
       return driver.findElement(By.id("user-name"));
    }

    //get input password field
    private WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }

    //get login button
    private WebElement getLoginButton(){
        return driver.findElement(By.id("login-button"));
    }

    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //login on site with username and password
    public void login(String username, String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
