package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02My {
  //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //        ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @AfterClass
    public static void tearDown() {
       // driver.close();
    }


    @Test
    public void test01() {
       // https://www.bestbuy.com/ Adresine gidin
          //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       driver.get("https://www.bestbuy.com/");
       String expectedUrl = "https://www.bestbuy.com/";
       String actuelUrl = driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actuelUrl);
     }

     @Test
    public void test02(){
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         String actuelTitle = driver.getTitle();
         String istenmeyenKelime = "Rest";
         Assert.assertFalse(actuelTitle.contains(istenmeyenKelime));
     }


     @Test
    public void test03(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
         WebElement bestBuyLogosu = driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));
         Assert.assertTrue(bestBuyLogosu.isDisplayed());

     }

    @Test
    public void test04(){
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());

    }



}
