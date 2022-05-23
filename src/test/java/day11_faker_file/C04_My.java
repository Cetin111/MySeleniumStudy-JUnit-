package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C04_My extends TestBase {
    @Test
    public void test(){
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dummy.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        System.out.println(System.getProperty("user.home")); //benim bilgisayarimin bana ozel farkli kismi

        String farkliKisim = System.getProperty("user.home"); //her bilgisayarda farkli
        String ortakKisim = "\\Downloads\\dummy.txt";  //her bilgisayardaki ortak kisim
        String indirilenDosyaYolu = farkliKisim+ortakKisim;  //dosya yolu

        Assert.assertTrue(Files.exists(Path.of(indirilenDosyaYolu)));



    }
}
