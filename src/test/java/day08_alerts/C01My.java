package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01My {


    // https://the-internet.herokuapp.com/javascript_alerts adresine gidiniz
    // karsiniza cikan JS alert te Ok e tiklayiniz
    // alert te ok e tikla
    // result kisminda "You successfully clicked an alert" yazdigini test edin

    WebDriver driver;

    @Before
    public void setUp(){
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
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidiniz
        // karsiniza cikan JS alert te Ok e tiklayiniz
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);

        // alert te ok e tikla
        driver.switchTo().alert().accept();

        // result kisminda "You successfully clicked an alert" yazdigini test edin

        System.out.println(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());

    }

}
