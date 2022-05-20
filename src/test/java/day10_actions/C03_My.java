package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_My extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement noktaliAlanElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(noktaliAlanElementi).perform();  //contextclick, sagtiklamak icin

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String arananYazi = "You selected a context menu";
        String alerttekiYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(alerttekiYazi,arananYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ilkSayfaHandleDegeri = driver.getWindowHandle(); //ilksayfa hash kodu

        Set<String> hashKodlar = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = "";

        for (String each: hashKodlar
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String arananYazi2 = "Elemental Selenium";
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        String sonucYazisiStr = sonucYazisi.getText();

        Assert.assertEquals(sonucYazisiStr,arananYazi2);

    }
}
