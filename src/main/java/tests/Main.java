package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","C:\\instaladores\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("D:\\PRACTICAS-QA-AUTOMATION\\SauceDemo\\src\\main\\resources\\data.properties");
        properties.load(fis);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        //Login
        Auth auth = new Auth();
        auth.login(driver,username,password);

        //Filter products Price (low to high)
        Filter filter = new Filter();
        filter.filterLowHigh(driver);


    }
}