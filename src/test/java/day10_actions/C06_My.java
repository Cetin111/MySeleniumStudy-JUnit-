package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_My extends TestBase {

    // facebook ana sayfaya gidip
    // yeni kayit olustur butonuna basalim
    // isim kutusunu locate edip
    // geriye kalan alanlari tab ile dolasarak formu doldurun


    @Test
    public void test() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();

        WebElement nameBox = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        nameBox.sendKeys("Ilker");

        Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.TAB)
                .sendKeys("Kaya")
                .sendKeys(Keys.TAB)
                .sendKeys("05323212526")
                .sendKeys(Keys.TAB)
                .sendKeys("sifre").perform();






    }
}
