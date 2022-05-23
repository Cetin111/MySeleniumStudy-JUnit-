package day11_faker_file;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_My {

    @Test
    public void test() {

        //masa ustundeki ilkerText.txt  dosyasi bilgisayarimizda varmi yokmu test edelim.
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\ilkerText.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
