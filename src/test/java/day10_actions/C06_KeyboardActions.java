package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test() {
        // facebook ana sayfaya gidip
        // yeni kayit olustur butonuna basalim
        // isim kutusunu locate edip
        // geriye kalan alanlari tab ile dolasarak formu doldurun


        driver.get("https://www.facebook.com");

        // yeni kayit olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // isim kutusunu locate edip
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari tab ile dolasarak formu doldurun
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Kaya")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .sendKeys("asdasf@fdfgdgdg")
                .perform();



    }
}
