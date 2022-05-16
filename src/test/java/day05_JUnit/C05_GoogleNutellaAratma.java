package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_GoogleNutellaAratma {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void test() {
        // https://www.google.com adresine gidin
        driver.get("https://www.google.com");

        // cookies uyarisini kabul ederek kapatin
        //cookies yok

        // sayfa basliginin 'Google' ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actuelTitle = driver.getTitle();

        if (expectedTitle.equals(actuelTitle)) {
            System.out.println("Sayfa basligi \"Google\" kelimesini iceriyor. Test PASSED");
        } else
            System.out.println("Sayfa basligi Google kelimesini icermiyor. Test FAILED");


        // Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella" + Keys.ENTER);

        // Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String[] arr = bulunanSonuc.getText().split(" ");
        System.out.println("Nutella aramasinda buluna sonuc = " + arr[1]);

        // sonuc sayisinin 10 milyondan fazla oldugunu test edin
        int sonucInt = Integer.parseInt(arr[1].replace(".",""));

        if (sonucInt > 10000000) {
            System.out.println("Arama sonucu 1o milyondan fazla. Test PASSED");
        }else
            System.out.println("Arama sonucu 1o milyondan fazla degil. Test FAILED");


    }
   // sayfayi kapatin
}
