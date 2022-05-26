package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.util.List;

public class C02My extends TestBase {
    //● Bir class oluşturun : C02_WebTables
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
    //            ○ Username : manager
    //            ○ Password : Manager1!
    //● table( ) metodu oluşturun
    //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows( ) metodu oluşturun //tr
    //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    //Email basligindaki tum elementleri(sutun) konsola yazdirin.

    @Test
    public void test() {
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        //            ○ Username : manager
        //            ○ Password : Manager1!

        driver.get("https://www.concorthotel.com//admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[@class='btn btn-success uppercase']")).click();
        System.out.println("*****************");

        //● table( ) metodu oluşturun
        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> bodySutunSayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        System.out.println("body sutun sayisi :" +bodySutunSayisi.size());
        System.out.println("*****************");
        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement bodyListesi = driver.findElement(By.xpath("//tbody"));
        System.out.println(bodyListesi.getText());

        WebElement headersListesi = driver.findElement(By.xpath("//thead/tr[1]"));
        System.out.println(headersListesi.getText());
        System.out.println("*****************");
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> bodySatirSayisi = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("body satir sayisi : " +bodySatirSayisi.size());
        System.out.println("*****************");
        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement each : bodySatirSayisi
             ) {
            System.out.println(each.getText());
        }
        System.out.println("*****************");
        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> satir4Elementler = driver.findElements(By.xpath("//tbody/tr[4]"));

        for (WebElement each : satir4Elementler
             ) {
            System.out.println(each.getText());
        }



    }


}
