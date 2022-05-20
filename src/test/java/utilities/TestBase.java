package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //abstract yapmamizin nedeni, bu class dan obje uretilmesinin onune gecmek icin

    // Bu class abstract yapildi ve alt satirdaki Webdriver onune protected yazildi.
    // artik test icin ailacak her class bu class a extend edilerek baslangic v bitis ayarlari burdan calistirilabilecek.
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){
        // driver.quit();
    }



}
