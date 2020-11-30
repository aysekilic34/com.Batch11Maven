package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1- https://www.saucedemo.com/ sayfasına gıdın
        driver.get("https://www.saucedemo.com/");

        //username standard_user yazdırın
        WebElement usernameBox=driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("standard_user");


        //paswrd secret_sauce yazdırın
        WebElement passwordBox=driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");

        //login butonuna basın
        driver.findElement(By.id("login-button")).click();

        //ilk urunun ısmını kaydedın ve bu urunun sayfasına gıdın
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunAdi=ilkUrun.getText();
        ilkUrun.click();

        //add to cart butonuna basın
        driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();

        //alısverıs sepetıne tıklayın
        driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();

        //sectıgınız urunun basarılı sekılde eklendıgını kontrol edın
        WebElement sepettekiUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunİsmi=sepettekiUrun.getText();
        if (ilkUrunAdi.equals(sepettekiUrunİsmi)){
            System.out.println("sepetteki urun testi PASS");
        }else{
            System.out.println("sepetteki urun testi FAİLED");
            System.out.println("sectiginiz urun ıle sepettekı urun farklı");
        }

        //sayfasyı kapatn

        driver.close();
    }
}
