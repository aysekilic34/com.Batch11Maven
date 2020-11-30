package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1-amazon adresine git
        driver.get("https://www.amazon.com.tr/");


        //2-arama kutusunu locate et
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3-"Samsung headphones" ile arama yap
        String arananKelime="Samsung headphones";
        searchBox.sendKeys(arananKelime+ Keys.ENTER);
       // searchBox.submit();

        //4-Bulunan sonuc sayısını yazdıralım
        WebElement sonucSayisi=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucSayisi.getText());

        //ilk urunu tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        driver.navigate().back();



        //Syfadakı tum baslıkları yazdıralım
        List<WebElement> baslikListeleri = (List<WebElement>) driver.findElement(By.xpath("//span[@dir='auto']"));
        for (WebElement w:baslikListeleri
             ) {
            System.out.println(w.getText());
        }
        driver.close();


        

    }
}
