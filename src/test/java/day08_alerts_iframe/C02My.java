package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02My {
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.

    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.

    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    public void test01() {
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement bulunanElement = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String bulunanString = bulunanElement.getText();
        String arananString = "You successfully clicked an alert";
        Assert.assertTrue(bulunanString.contains(arananString));

    }

    @Test
    public void test02() {

        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //      “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement bulunanElement =  driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String bulunanString = bulunanElement.getText();
        String arananString = "Cancel";
        Assert.assertTrue(bulunanString.contains(arananString));

    }

    @Test
    public void test03() {
    // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("IlkerKaya");
        driver.switchTo().alert().accept();

        WebElement bulunanElement =  driver.findElement(By.xpath("//p[@id='result']"));
        String bulunanString = bulunanElement.getText();
        String arananString = "IlkerKaya";
        Assert.assertTrue(bulunanString.contains(arananString));


    }

}