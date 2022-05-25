package team5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C08 extends TestBase {
    // 1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin


    @Test
    public void test1() {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaHemdleDegeri = driver.getWindowHandle();


        //2."Login Portal" a kadar asagi inin
        //3."Login Portal" a tiklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();


        //4.Diger window'a gecin
        Set<String> handleListesi = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = "";
        for (String each : handleListesi
             ) {
            if (!each.equals(ilkSayfaHemdleDegeri)){
               ikinciSayfaHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);


        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("kenanCakir");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();


        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedStr = "validation failed";
        String alertStr = driver.switchTo().alert().getText();
        Assert.assertTrue(alertStr.contains(expectedStr));


        //    8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();


        //  9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHemdleDegeri);


        //10.Ilk sayfaya donuldugunu test edin
        String ilkSayfaUrl = "http://webdriveruniversity.com/";
        Assert.assertTrue(driver.getCurrentUrl().contains(ilkSayfaUrl));

        driver.quit();





    }

}
