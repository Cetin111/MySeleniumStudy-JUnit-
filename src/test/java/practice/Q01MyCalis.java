package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01MyCalis {

      /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin

    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
 */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void testtenOnce() {
        driver.get("https://www.google.com");
    }

    @Test
    public void test1() {
        //arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.sendKeys("Green Mile");
        aramaKutusu.submit();

    }

    @Test
    public void test2(){
        //  arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.sendKeys("Premonition");
        aramaKutusu.submit();
    }


    @After
    public void testtenSonra() {
        WebElement sonucElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucString = sonucElementi.getText();
        System.out.println(sonucString);

        //   driver.close();
    }


    @AfterClass
    public static void tearDown() {
        //    driver.quit();
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));

    }


}
