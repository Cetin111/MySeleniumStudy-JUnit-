package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir")); //C:\com.Batch59JUnit
                        //bana icinde oldugum projenin dosya yolunu(path) verir
        System.out.println(System.getProperty("user.home"));
                        //benim bilgisayarimin bana ozel kismini verdi

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\ilkerText.txt";
        System.out.println(dosyaYolu);
        //yukarisini anlatmak icin yazdi.


        //bir dosya bilgisayarimizda varmi yokmu test etmek icin.
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\ilkerText.txt";
        String masaustuDosyaYolu = farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu))); //masaustundeki ilkerText.txt varmi kontrol ediyor.


        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));



    }
}
