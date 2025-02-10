package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Filter {

    public void filterLowHigh(WebDriver driver){
       WebElement dropdown = driver.findElement(By.className("product_sort_container"));
       Select select = new Select(dropdown);
       select.selectByValue("lohi");

    }
}
