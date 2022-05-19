package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01My {
    // 1- amazon ana sayfaya gidin
    // 2- nutella icin arama yaptirin
    // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
    // 4- yeni tab'da acilan urunun title'ini yazdirin
    // ilk sayfaya gecip url'i yazdiralim

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       driver.quit();
    }
    @Test
    public void test01() {
        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String amazonSayfaHashKod = driver.getWindowHandle();  //amazon giris sayfasi hash kodu

        // 2- nutella icin arama yaptirin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();

        // 4- yeni tab'da acilan urunun title'ini yazdirin
        System.out.println("Yeni tabin basligi : " +driver.getTitle());

        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(amazonSayfaHashKod);
        System.out.println("Amazon un Url i : " +driver.getCurrentUrl());



    }
}
