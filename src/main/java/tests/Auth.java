package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth {

    //WebDriver driver;

    public void login(WebDriver driver,String user, String password) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
