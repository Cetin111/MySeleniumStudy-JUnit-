package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dummy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        Thread.sleep(5000);

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
                //bize downloads in dosya yolu lazim
        String farkliKizim = System.getProperty("user.home"); //bu standart herkez aynisini yazcak
                                    //herbilgisayar icin farkli o nedenle
        String ortakKisim = "\\Downloads\\dummy.txt"; //buda tum bilgisayarlar icin ortak.
        String arananDosyaYolu = farkliKizim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }
}
