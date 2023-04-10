package Gun07;

import Utility.BaseDriverChrome;
import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriverParameter {
    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elemanlardan random bir elemanı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
    @Parameters("search")
    @Test
    void test(String wordToSearch){
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys(wordToSearch);
        search.sendKeys(Keys.ENTER);

        List<WebElement> captions = driver.findElements(By.xpath("//div[@id='content']/div/div//h4"));
        int randomNum = Tools.randomGenerator(captions.size());
        String wishItemText = captions.get(randomNum).getText();
        System.out.println("wishItemText = " + wishItemText); //kontrol
        List<WebElement> wishLists = driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishLists.get(randomNum).click();
        driver.findElement(By.linkText("Wish List")).click();
        List<WebElement> wishItems = driver.findElements(By.cssSelector("td[class='text-left']>a"));
        Tools.listContainsString(wishItems, wishItemText);

    }
}
