package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage {

    private WebDriver driver;


    private WebElement getUsernameField(){
       return driver.findElement(By.id("user-name"));
    }


    private WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }


    private WebElement getLoginButton(){
        return driver.findElement(By.id("login-button"));
    }

    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
