package team5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01My extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin

    @Test
    public void test(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");


        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement buton1 = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(buton1).perform();


        //3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.click(link1).perform();


        //4. Popup mesajini yazdirin
        //5. Popup'i tamam diyerek kapatin
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //6. "Click and hold" kutusuna basili tutun
        WebElement buton2 = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(buton2).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(buton2.getText());


        //8. "Double click me" butonunu cift tiklayin
        WebElement buton3 = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(buton3).perform();



    }


}
