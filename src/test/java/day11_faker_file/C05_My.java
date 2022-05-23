package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C05_My extends TestBase {
    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test(){
        //2.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");


        //3.chooseFile butonuna basalim
        //4.Yuklemek istediginiz dosyayi secelim.
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        String fakliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\ilkerText.txt";
        String yuklenecekDosyaYolu = fakliKisim+ortakKisim;

        dosyaSecButonu.sendKeys(yuklenecekDosyaYolu);

        //5.Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement actuelText = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        Assert.assertTrue(actuelText.isDisplayed());

    }

}
