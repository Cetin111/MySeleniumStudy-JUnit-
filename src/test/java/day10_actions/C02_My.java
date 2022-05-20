package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_My extends TestBase {
    //amazon.com a gir
    //account list menusunden create a list linkine tiklayin

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);
        WebElement accountListElementi = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(accountListElementi).perform();   //perform her aksiyon sonunda standart ekleniyor..

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }

}
