package day05_JUnit;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Odev3 {
    // https://www.saucedemo.com adresine gidin
    // Username kutusuna "standard_user" yazdirin
    // Password kutusuna "secret_sauce" yazdirin
    // Login tusuna basin
    // ilk urunun ismini kaydedin ve bu urununu sayfasina gidin
    // Add to Card butonuna basin
    // Alisveris sepetine tiklayin
    // Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
    // sayfayi kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.saucedemo.com adresine gidin
        // Username kutusuna "standard_user" yazdirin
        // Password kutusuna "secret_sauce" yazdirin
        // Login tusuna basin
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //// ilk urunun ismini kaydedin ve bu urununu sayfasina gidin
        WebElement ilkUrunElement = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String ilkUrun = ilkUrunElement.getText();
        System.out.println(ilkUrun);
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();

        // Add to Card butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        // Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        // Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
        // sayfayi kapatin

        WebElement actuelElement = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

        System.out.println(actuelElement.isDisplayed());

        driver.close();

    }
}
