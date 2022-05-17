package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04My {
    ///* amazon'a gidip
    //   dropdown'dan books secenegini secip
    //   Java aratalim
    //   ve arama sonuclarinin Java icerdigini test edelim
    // */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        //  amazon'a gidip
        //  dropdown'dan books secenegini secip java aratalim
        driver.get("https://www.amazon.com");
       WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
       Select select = new Select(dropDownMenu);
       select.selectByVisibleText("Books");
       //select.selectByIndex(5);
       //select.selectByValue("search-alias=stripbooks-intl-ship");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //ve arama sonuclarinin Java icerdigini test edelim
        String arananKelime = "Java";
        WebElement actuelSonucYazisi = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        String sonucYazisi = actuelSonucYazisi.getText();
        Assert.assertTrue(sonucYazisi.contains("Java"));



    }



}
