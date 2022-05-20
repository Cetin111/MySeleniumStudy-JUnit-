package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {
        //amazon.com a gir
        //account menusunden create a list linkine tiklayin
        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);
        WebElement accountlinki = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountlinki).perform(); //moveToElement uzerine gider bekler

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }

}
