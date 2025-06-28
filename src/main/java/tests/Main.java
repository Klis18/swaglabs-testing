package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws IOException {
        // Configura automáticamente el driver adecuado
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        //Configuración de lectura de propiedades
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("D:\\PRACTICAS-QA-AUTOMATION\\SauceDemo\\src\\main\\resources\\data.properties");
        properties.load(fis);

        //Obtención de datos desde archivo
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String firstName = properties.getProperty("first_name");
        String lastName = properties.getProperty("last_name");
        String postalCode = properties.getProperty("postal_code");

        //Ejecución de pruebas
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        //Login
        Auth auth = new Auth();
        auth.login(driver,username,password);

        //Filter products Price (low to high)
        Filter filter = new Filter();
        filter.filterLowHigh(driver);

        //Add products to cart
        Cart cart = new Cart();
        cart.AddProductCard(driver);

        //Checkout
        Checkout checkout = new Checkout();
        checkout.Checkout(driver, firstName, lastName, postalCode);

    }
}