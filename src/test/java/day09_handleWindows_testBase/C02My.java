package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02My {
    // 1- amazon ana sayfaya gidelim
    // 2- Url in amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- Titile in Best Buy icerdigini test edelim
    // 5- ilk sayfaya donup sayfada java aratalim.
    // 6- arama sonuclarinin java icerdigini test edelim
    // 7- yeniden bestbuy in acik oldugu sayfaya gidelim
    // 8- Logonun gorundugunu test edelim.

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
     //   driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String amazonHashCode = driver.getWindowHandle();

        // 2- Url in amazon icerdigini test edelim
        String urldeArananKelime = "amazon";
        String  actuelUrl = driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(urldeArananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHashCode = driver.getWindowHandle();

        // 4- Titile in Best Buy icerdigini test edelim
        String titledaAranankelime = "Best Buy";
        String actuelTitle = driver.getTitle();
        Assert.assertTrue(actuelTitle.contains(titledaAranankelime));

        // 5- ilk sayfaya donup sayfada java aratalim.
        driver.switchTo().window(amazonHashCode);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYaziString = sonucYaziElementi.getText();
        String sonucdaArananKelime = "Java";
        Assert.assertTrue(sonucYaziString.contains(sonucdaArananKelime));

        // 7- yeniden bestbuy in acik oldugu sayfaya gidelim
        driver.switchTo().window(bestBuyHashCode);

        // 8- Logonun gorundugunu test edelim.





    }
}
