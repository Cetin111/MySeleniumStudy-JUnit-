package team5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeOdev extends TestBase {
    // http://www.webdriveruniversity.com/IFrame/index.html sayfasina gidin
    // "Our Products" butonuna basin
    // "Cameras product" i tiklayin
    // Popup mesajini yazdirin
    // "close" butonuna basin
    // WebdriverUniversity.com (IFrame) linkine tiklayin
    // "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test() {
        // http://www.webdriveruniversity.com/IFrame/index.html sayfasina gidin
        driver.get("http://www.webdriveruniversity.com/IFrame/index.html");

        // "Our Products" butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        // "Cameras product" i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();

        // Popup mesajini yazdirin

        WebElement popupMesaji = driver.findElement(By.xpath("//*[text()='Please Note: All orders must be over the value of £50, adding additional coupon codes to the basket are excluded from this offer. To receive 30% off please add the following code to the basket: ']"));
        System.out.println(popupMesaji);

        // "close" butonuna basin
        WebElement closeTusuElemnti = driver.findElement(By.xpath("//*[text()='Close']"));
        closeTusuElemnti.sendKeys(Keys.ENTER);

        // WebdriverUniversity.com (IFrame) linkine tiklayin
        WebElement tiklancakyer = driver.findElement(By.xpath("//a[@id='nav-title']"));
        tiklancakyer.sendKeys(Keys.ENTER);

        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        //driver.switchTo().defaultContent();
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actuelUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actuelUrl);

    }

}
