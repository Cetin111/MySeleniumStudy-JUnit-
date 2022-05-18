package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04My {


    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.

    //   ● Bir metod olusturun: iframeTest
    //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //      ve  konsolda    yazdirin.

    //      ○ Text Box’a “Merhaba Dunya!” yazin.

    //      ○ TextBox’in altinda bulunan “Elemental Selenium”
    //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //    driver.close();
    }

    // Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        // ve  konsolda yazdirin.

        WebElement arananElement = driver.findElement(By.xpath("//h3['An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(arananElement.isEnabled());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBoxIfarameElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(textBoxIfarameElementi);
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        // TextBox’in altinda bulunan “Elemental Selenium”
        // linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        //  ***** once iframe den cikmamiz lazim..*******
        driver.switchTo().defaultContent();

        WebElement bulunanElement = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(bulunanElement.isDisplayed());

        System.out.println(bulunanElement.getText());


    }

}
