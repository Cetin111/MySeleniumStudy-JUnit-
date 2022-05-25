package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //1. apache poi dependency’i pom file’a ekleyelim
        //2. Java klasoru altinda resources klasoru olusturalim
        //3. Excel dosyamizi resources klasorune ekleyelim
        //4. excelAutomation isminde bir package olusturalim
        //5. ReadExcel isminde bir class olusturalim
        //6. readExcel() method olusturalim

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";  //projede degilde masaustunde olsaydi.
                                //degisen kisim ve degismeyen kisim seklinde yazacaktik.

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //dosyayi aldik

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);  //exel dosyasinin burdaki sanaldaki adi workbook
        //10.WorkbookFactory.create(fileInputStream)

        //11. sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); //exeldeki alttaki calisma sayfasi 1 e gittik

        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);  //ustten 3.index

        //13. Cell objesi olusturun
        Cell cell = row.getCell(3); //soldan3.index

        //row.getCell(index)
        System.out.println(cell);

        // exel tabloda index yukardan asagi yada soldan saga sifirdan basliyor.

        //3.indexteki satirin 3. index indeki datanin cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actuelData = cell.toString();
        //Assert.assertEquals(expectedData.equals(cell));  //cell in obje turu ceell, cezayirin data turu string hata verir
        Assert.assertEquals(expectedData,actuelData);   //buda olur
        Assert.assertEquals(expectedData,cell.getStringCellValue());  //buda olur

    }


}
