package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Ben {


    //1. Bir class oluşturun : CheckBoxTest
    WebDriver driver;
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
       driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chechBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement chechBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!chechBox1.isSelected()) {
            chechBox1.click();
        }
        Thread.sleep(3000);

        //d. Checkbox2 seçili değilse onay kutusunu tıklayın

        Thread.sleep(3000);
        if (!chechBox2.isSelected()); {
            chechBox2.click();
        }
        Thread.sleep(3000);

        driver.close();
    }





}
