package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


//1) Bir class oluşturun: BestBuyAssertions
//2) https://www.bestbuy.com/ Adresine gidin
//      farkli test method’lari olusturarak asagidaki testleri yapin
//          ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
//          ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
//          ○ logoTest => BestBuy logosunun görüntülendigini test edin
//          ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin


public class BestBuyAssertions {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void urlTest(){
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void titleTest(){
        String actualTitle=driver.getCurrentUrl();
        String expectedTitle="Rest";
        Assert.assertFalse(expectedTitle.contains(actualTitle));
    }
    @Test
    public void logoTest(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void fransizcaLinkTest(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLinki=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());
    }




    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
