package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {

    public void Checkout(WebDriver driver, String firstName, String lastName, String postalCode){
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.className("checkout_button")).click();
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        driver.findElement(By.className("btn_primary")).click();
        driver.findElement(By.linkText("FINISH")).click();

        String finishMessage =driver.findElement(By.className("complete-header")).getText();

        String finishMessageExpected = "THANK YOU FOR YOUR ORDER";

        if(finishMessageExpected.equals(finishMessage)){
            System.out.println("Mensaje correcto");
        }else{
            System.out.println("Mensaje incorrecto");
        }
    }
}
