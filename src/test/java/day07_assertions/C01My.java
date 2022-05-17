package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01My {
     /*
    amazon ana sayfaya gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */

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
        driver.close();
    }


    @Test
    public void test01() {
       // 1- Url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        String arananKelime = "amazon";
        String actuelUrl =  driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(arananKelime));

    }

    @Test
    public void test02(){
      //  title'in facebook icermedigini test edin
        String istenmeyenKelime = "facebook";
        String actuelTitile =  driver.getTitle();
        Assert.assertFalse(actuelTitile.contains(istenmeyenKelime));

    }

    @Test
    public void test3(){
        //sol ust kosede amazon logosunun gorundugunu test edin
        WebElement amazonLogo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }


}
