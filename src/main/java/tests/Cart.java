package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart {

    public void AddProductCard(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        for (var i = 0; i < 3; i++) {
            elements.get(i).click();
        }
    }
}
