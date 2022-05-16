package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04My {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test() throws InterruptedException {
        //https://www.amazon.com sitesine gidin
        driver.get("https://www.amazon.com");

        // url'in   WebDriverManager.chromedriver().setup(); oldugunu test edin
/*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");
*/
        Thread.sleep(3000);
        String expectedUrl = "https://www.facebook.com";
        String actuelUrl = driver.getCurrentUrl();
        Assert.assertEquals("Test Sonucu",expectedUrl,actuelUrl);

    }
}
