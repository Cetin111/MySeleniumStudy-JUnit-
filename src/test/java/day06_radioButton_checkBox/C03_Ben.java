package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Ben {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    //-https://www.facebook.com adresine gidin
    @Test
    public void test(){
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        //bende cikmadi

        //-“Create an Account” button’una basin


    }






    //-“Create an Account” button’una basin

    //-“radio buttons” elementlerini locate edin

    //-Secili degilse cinsiyet butonundan size uygun olani secin



}
