package Gun05;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _06_Task_2 extends BaseDriverParameter {
    /*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Çıkan ürünlerde (bütün ürünlerde indirim var mı eski fiyat yeni fiyattan büyük mü)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu anda ki fiyattan
      yüksek olduğunu doğrulayınız.
*/
    @Test
    void task(){
        driver.findElement(By.linkText("Specials")).click();
        List<WebElement> prices = driver.findElements(By.cssSelector("div[class='caption']>p[class]>span"));
        for (WebElement e : prices)
            System.out.println("e = " + e.getText());


    }
}
