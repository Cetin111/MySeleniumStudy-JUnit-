package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04My2 {

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
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        // ve  konsolda yazdirin.
        WebElement iframeElement = driver.findElement(By.xpath("//h3"));
        iframeElement.isEnabled();
        String iframeString = iframeElement.getText();
        System.out.println(iframeString);

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBoxElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); //textBox in iframe icerisinde
        //oldugunu gorduk. once Webelement ile iframe i locate ettik.
        driver.switchTo().frame(textBoxElement); //iframe katmanina gectik
        WebElement textBoxIframeElementi = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        //!!!!! iframe katmanina gectikten sonra textbox i tekrar locate ettik !!!1
        textBoxIframeElementi.clear(); //text boc taki onceki yaziyi sildir
        textBoxIframeElementi.sendKeys("...Merhaba Dunya..."); //text box a stringi yazdik

        // TextBox’in altinda bulunan “Elemental Selenium”
        // linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent(); //aradigimiz metin iframe katmaninda degil. o nedenle girdigimiz iframe den ciktik
        WebElement arananElement = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        System.out.println(arananElement.isDisplayed());
        System.out.println(arananElement.getText());

    }
}
