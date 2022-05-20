package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {  //utiities packed i icindeki TestBase clasinda
    // gerekli ayarlar yapildi ve TestBase de WebDriver.driver onune protected yazildi. clas abstract yapildi.

    // burdaki class da TestBase e extends edildi.
    //artik actigimiz her clasi TestBase extends ederek ayarlari ordan kullanicaz.

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
