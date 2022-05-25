package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {

        //inout olarak verilen
        //satirNo, sutunNo degerlerini parametre olarak alip
        //o cell deki datayi string olarak bana donduren bir method olusturun.

        int satirNo = 4;
        int sutunNo = 4;

        //donen string in Cezayir oldugunu test edin

        String expectedData = "Cezayir";

        String actuelData = banaDataGetir(satirNo-1,sutunNo-1);
                                //index girecegimiz icin satir sutun nodan 1 cikarttik.
        Assert.assertEquals(expectedData,actuelData);

    }

    public static String  banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;
    }
}
