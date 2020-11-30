package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // 1- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2-Signin butonuna basın
        driver.findElement(By.id("signin_button")).click();

        //Login alanına username yazın
        WebElement userNameTextBox=driver.findElement(By.id("user_login"));
        userNameTextBox.sendKeys("username");

        //password alanına password yazın
        WebElement passwordTextBox=driver.findElement(By.id("user_password"));
        passwordTextBox.sendKeys("password");


        //sign in butonuna basın
        driver.findElement(By.name("submit")).click();


        //Pay Bills sayfasına gıdın
        driver.findElement(By.id("pay_bills_tab")).click();

        //amount kısmına yatırmak ıstedıgınız herhangı bır mıktar
        WebElement amountTextBox=driver.findElement(By.id("sp_amount"));
        amountTextBox.sendKeys("250");

        //tarıh kısmına 2020-09-10
        WebElement tarihKutusu=driver.findElement(By.id("sp_date"));
        tarihKutusu.sendKeys("2020-09-10");

        //pay butonuna tıklayın
        driver.findElement(By.id("pay_saved_payees")).click();

        //"The payment was successfully submitted" mesajının cıktıgını kontrol edın
        WebElement basarili=driver.findElement(By.id("alert_content"));
        if (basarili.isDisplayed()){
            System.out.println("havale basaılı yazısı testı PASS");
        }else {
            System.out.println("havale basarılı testi FAİLED");
        }

        driver.close();
    }
}
