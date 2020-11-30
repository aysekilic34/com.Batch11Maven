package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();



        //1- https://www.walmart.com/ sayfasına gidin
        driver.get("https://www.walmart.com/");

        //2-browser i tam sayfa yapın
        driver.manage().window().maximize();

        //Sayfayı represh yapın
        driver.navigate().refresh();

        //sayfa baslıgının save ifadesini icerdigini kontrol edın
        String actualTitle=driver.getTitle();
        String arananKelimeTitle="Save";
        if (actualTitle.contains(arananKelimeTitle)){
            System.out.println("Title testi PASS");
        }else{
            System.out.println("Title testi FAİLED");
            System.out.println("sayfa baslıgı\""+ arananKelimeTitle+"\"İcermiyor");
        }


        //sayfa baslgının Walmart.com | Save Money.Live Better a esit old. kontrol edin

        String expectedTitle="Walmart.com | Save Money.Live Better";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("title Walmart testi PASS");
        }else{
            System.out.println("title Walmart testi FAİLED");
            System.out.println("sayfa baslıgı \""+expectedTitle+ "\"esit degil");
        }


        //URL nin walmart.com icerdigini kontrol edın

        String  actualURL=driver.getCurrentUrl();
        String arananKelime="walmart.com";

        if (actualURL.contains(arananKelime)){
            System.out.println("URL testi PASS" );
        }else {
            System.out.println("URL test FAİLED");
        }

        //Nutella ıcın arama yapın
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement aramaCubugu=driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String aramaKElimesi="Nutella";
        aramaCubugu.sendKeys(aramaKElimesi+ Keys.ENTER);
        //aramaCubugu.submit();



        //kac sonuc buldugunuzu yazdırın

        WebElement sonucYazisi=driver.findElement(By.className("result-summary-container"));
        System.out.println(sonucYazisi.getText());


        //sayfayı kapatın
        driver.close();
    }
}
