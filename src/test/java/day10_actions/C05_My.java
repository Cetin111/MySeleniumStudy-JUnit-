package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_My extends TestBase {
    //amazona gidelim
    //once arama kutusuna click yapip
    //sonra harf harf Nutella yazdiralim
    //sonra da ENTER tusuna basalim.

    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://www.amazon.com");

        //once arama kutusuna click yapip
        //sonra harf harf Nutella yazdiralim
        //sonra da ENTER tusuna basalim.

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).perform();

        actions
                .sendKeys("N")
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a").sendKeys(Keys.ENTER).perform();


    }
}
