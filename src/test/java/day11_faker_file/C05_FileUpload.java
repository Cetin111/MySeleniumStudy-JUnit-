package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.


    @Test
    public void test01() throws InterruptedException {
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        //4.Yuklemek istediginiz dosyayi secelim.
        /*bu islemi selenium ile yapamayiz, cunki web tabanli bir uygulama degil
        bu durumda sendKeys imdada yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz secme islemi
        otomatik olarak yapilmis olacak

         */

        //1.adim: choose file butonunu locate edelim
        WebElement dosyaSecButonu = driver.findElement(By.id("file-upload"));
        //2.adim yuklenecek dosyanin dosya yolunu olustralim
                //biz masasutumuzdeki ilkerText.txt yi gonderelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim="\\Desktop\\ilkerText.txt";
        String yuklenecekDosya = farkliKisim+ortakKisim;
        //3.adim: sendKeys ile dosya yolunu secme butonuna gyollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);
        Thread.sleep(5000);

        //5.Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        Thread.sleep(5000);


    }
}
