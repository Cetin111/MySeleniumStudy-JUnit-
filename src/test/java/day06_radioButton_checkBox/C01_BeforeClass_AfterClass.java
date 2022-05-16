package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
    /* @beforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir.

    ---> clasin basinda @BeforeClass calisir methodlarin hepsi calistikdan
                sonra class in sonunda da @AfterClass calisir <---

    */


   static WebDriver driver;   //static yaptik

    @BeforeClass
    public static void setup() {  //static yaptik
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {    //stastic yaptik
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test0() {
        driver.get("https://www.facebook.com");
    }



}
