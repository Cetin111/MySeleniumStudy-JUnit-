package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Ben {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    //-https://www.facebook.com adresine gidin
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        //bende cikmadi

        //-“Create an Account” button’una basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

    //-“radio buttons” elementlerini locate edin
        WebElement kadinButonuElementi = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButonuElementi = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButonuElementi = driver.findElement(By.xpath("//input[@value='-1']"));

    //-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!erkekButonuElementi.isSelected()){
            erkekButonuElementi.click();
        }
        Thread.sleep(3000);

    }
}
