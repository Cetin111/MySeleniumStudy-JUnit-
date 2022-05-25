package team5;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoper=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoper).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();


        //4. Popup mesajini yazdirin
        String mesaj=driver.switchTo().alert().getText();
        System.out.println(mesaj);


        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        //6. "Click and hold" kutusuna basili tutun
        WebElement click=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(click).perform();
        Thread.sleep(3000);


        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(click.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi=driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClickElementi).perform();


    }
}
