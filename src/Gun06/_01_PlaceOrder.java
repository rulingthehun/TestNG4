package Gun06;

import Utility.BaseDriverChrome;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_PlaceOrder extends BaseDriverChrome {
    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
    @Test
    void addToCard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("ipod");
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        //driver.findElement(By.id("cart")).click();
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.linkText("Checkout")).click();
        WebElement paymentAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        paymentAddress.click();
        WebElement shippingAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        shippingAddress.click();
        WebElement shippingMethod = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        shippingMethod.click();
        WebElement agree = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        agree.click();
        WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        paymentMethod.click();
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        confirmButton.click();
        wait.until(ExpectedConditions.urlContains("success"));
        WebElement content = driver.findElement(By.cssSelector("[id='content']>h1"));
        Assert.assertEquals(content.getText(), "Your order has been placed!", "Text is not found");

    }
}
