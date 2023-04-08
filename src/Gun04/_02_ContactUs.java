package Gun04;

import Utility.BaseDriverChrome;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class _02_ContactUs extends BaseDriverChrome {
    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
    @Test
    @Parameters("message") //xml parametre adı
    void contactUs(String gelenMesaj){ //Methodun alacağı değer
        driver.findElement(By.linkText("Contact Us")).click();
        WebElement name = driver.findElement(By.id("input-name"));
        name.clear();
        name.sendKeys("Ruling");
        WebElement email = driver.findElement(By.id("input-email"));
        email.clear();
        email.sendKeys("gg@gmail.com");
        driver.findElement(By.id("input-enquiry")).sendKeys(gelenMesaj);
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        Tools.Wait(0.4);
        Assert.assertTrue(driver.getCurrentUrl().contains("succes"));

    }
}
