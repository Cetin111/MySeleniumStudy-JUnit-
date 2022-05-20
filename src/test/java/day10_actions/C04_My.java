package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_My extends TestBase {

    //Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void name() {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");


        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        // WebElement alert = driver.findElement(By.xpath("//div[@id='backgroundImage']"));

      //  driver.switchTo().alert();
      //  driver.findElement(By.xpath("//div[@id='cbb']")).click();

        Actions actions = new Actions(driver);
        WebElement ilkButon = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement ikinciButon = driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(ilkButon,ikinciButon).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String arananKelime = "Dropped!";
        WebElement actuelElement = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String sonucStr = actuelElement.getText();
        Assert.assertTrue(sonucStr.contains(arananKelime));




    }
}
